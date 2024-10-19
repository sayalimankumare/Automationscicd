	@tag
	Feature:Purchase the order from Ecommerce Website
		I want to use this template for my feature file

	Background:
	Given I Landed on ecommerce Page

	@Regression
	Scenario Outline:Positive Test of Submitting  the order 
	
	Given Logged in the username <name> and password <password>
	When I Add Product <productName>to Cart
	And Checkout <productName>and submit the order
	Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	
	Examples:
		|name 				   |password           |productName|
		
		|rahulshetty@gmail.com |IamKing@000        |ZARA COAT 3|
