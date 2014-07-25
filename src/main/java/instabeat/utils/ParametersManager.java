package instabeat.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParametersManager {

	public String EmailField;
	public String PasswordField;
	public String LoginButton;
	public String GetStartedLink;
	public String ForgotPasswordLink;
	public String LogoutLink;
	public String GetSL;

	public String NewPasswordField;
	public String ConfirmNewPasswordField;
	public String ResetPasswordButton;

	public String UserEmail;
	public String UserPassword = "";

	public String FirstNameField;
	public String LastNameField;
	public String DateOfBirthField;
	public String HeightField;
	public String WeightField;
	public String SignUpButton;
	
	public String RHRField;
	public String CalendarButton;
	public String CalculateHRButton;
	public String UpdateButton;
	
	public String GL_URL;
	public String Amazon_URL;

	public void getPropertyFields() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src/parameters.properties");
			prop.load(input);
			
					
			/*Login Page*/
			EmailField = prop.get("UserEmailField").toString();
			PasswordField = prop.get("PasswordField").toString();
			LoginButton = prop.get("LoginButton").toString();

			GetStartedLink = prop.get("GetStartedLink").toString();
			ForgotPasswordLink = prop.get("ForgotPasswordLink").toString();
			LogoutLink = prop.get("LogoutLink").toString();
			// GetSL = prop.get("GetSL").toString();

			UserEmail = prop.get("InputUserEmail").toString();
			UserPassword = prop.get("InputUserPassword").toString();

			/*ResetPasword Page*/
			NewPasswordField = prop.get("NewPasswordField").toString();
			ConfirmNewPasswordField = prop.get("ConfirmNewPasswordField")
					.toString();
			ResetPasswordButton = prop.get("ResetPasswordButton").toString();

			/*GetStarted Page*/
			FirstNameField = prop.get("FirstNameField").toString();
			LastNameField = prop.get("LastNameField").toString();
			DateOfBirthField = prop.get("DateOfBirthField").toString();
			HeightField = prop.get("HeightField").toString();
			WeightField = prop.get("WeightField").toString();
			SignUpButton = prop.get("SignUpButton").toString();

			RHRField = prop.get("RHRField").toString();
			CalculateHRButton = prop.get("CalculateHRButton").toString();
			UpdateButton = prop.get("UpdateButton").toString();
			
			/*Dashboard*/
			CalendarButton = prop.get("CalendarButton").toString();
			
			/* URL's */
			GL_URL = prop.get("GL_URL").toString();
			Amazon_URL = prop.get("Amazon_URL").toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	


	/*
	 * public void getPropertyValues () { Properties prop = new Properties();
	 * InputStream input = null;
	 * 
	 * try{ input = new FileInputStream("src/parameters.properties");
	 * prop.load(input);
	 * 
	 * //UserEmail = prop.get("InputUserEmailField").toString(); //UserPassword
	 * = prop.get("").toString();
	 * 
	 * } catch (IOException e){ e.printStackTrace(); } }
	 */
}
