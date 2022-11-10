Feature: Smoke Testing of nopCommerce Login functionality

  Scenario: Test login functionality with valid credentials
    Given user is open the browser
    When user enter url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And user enter the valid username as "admin@yourstore.com" and password as "admin"
    And user clicks on login button
    Then page Title should be "Dashboard / nopCommerce administration" 
    When user clicks on Logout link
    Then page Title should be "Your store. Login"    
    And close the browser

  Scenario Outline: Test login functionality with valid credentials
    Given user is open the browser
    When user enter url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And user enter the valid username as "<username>" and password as "<password>"
    And user clicks on login button
    Then page Title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then page Title should be "Your store. Login"
    And close the browser

    Examples: 
      | username            | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |
