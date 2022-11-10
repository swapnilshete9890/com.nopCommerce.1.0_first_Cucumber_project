Feature: Customers

  Background: Below are the common steps for each Scenario
    Given user is open the browser
    When user enter url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And user enter the valid username as "admin@yourstore.com" and password as "admin"
    And user clicks on login button
    Then User can view Dashboard

  Scenario: Add a new Customer
    When User click on cutomers menu
    And click on customers from menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close the browser
#
  #Scenario: Search Customer by Email
    #When User click on cutomers menu
    #And click on customers from menu item
    #And Enter customer Email
    #When click on search button
    #Then user should found Email in the search table
    #And close the browser
#
  #Scenario: Search Customer by Name
    #When User click on cutomers menu
    #And click on customers from menu item
    #And Enter customer FirstName
    #And Enter customer LastName
    #When click on search button
    #Then user should found Name in the search table
    #And close the browser
