Feature: User Login
User should able to login 

  Scenario: Login with valid Credentials 
    Given User navigates to Login Page 
     When User enters valid Username and Password
     And Clicks on Login button 
     Then User should Login Successfully and navigates to Dashboard 
     When user add products in the cart
     And user should able to make the Purchase successfully 
     Then user should get a proper Confirmation Screen