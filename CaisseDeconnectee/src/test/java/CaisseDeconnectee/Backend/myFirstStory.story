Narrative: Testing
Scenario: As a user I should be able to login 
Given I am in authentification page
And I enter my username: <username> and my password: <password>
When The username: <username> and the password: <password> are correct
Then I am able to connect

Examples:
|username       |password|
|popo	        |poo     |
   


Scenario: the user write wrong username and password
Given I am in authentification page!
And I enter my username2: <username> and my password2: <password>
When The username2: <username> and the password2: <password> are not correct
Then I am not able to connect

Examples:
|username       |password|
|yosra	        |haddad   |

Scenario: show Bills success

Given give a bill reference <ref>
Then show bill
Examples:
|ref|   
|string| 


