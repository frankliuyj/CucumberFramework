@web
Feature: Login: As a enduser of 163 mail, I can login into web mail with username and password 

  @success
  Scenario: Success
    Given go to login page
    When login with "13810033664" "198112abc"
    Then redirect to dashboard page

  @failed
  Scenario Outline: Failed
    Given go to login page
    When login with <username> <password>
    Then should display error <message>

	Examples: data
	| username         | password         | message  			   |
	| "13810033664"     | "198112ab"         | "帐号或密码有误，请重试"  |
	| "13810033664" 	   | "empty"        	  | "请输入邮箱密码"  		   |
	| "empty" 		   | "198112"        	  | "请输入帐号"  		   |