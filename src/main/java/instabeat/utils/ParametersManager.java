package instabeat.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParametersManager {

	public String EmailField;
	public String PasswordField;

	public String NewPasswordField;
	public String ConfirmNewPasswordField;

	public String UserEmail;
	public String UserPassword;

	public String DefaultPoolLength;
	public String DateOfBirthField;
	public String FirstNameField;
	public String LastNameField;
	public String SignUpButton;
	public String HeightField;
	public String WeightField;
		
	public String GL_URL;
	public String Amazon_URL;
	public String FBUserEmail;
	public String TwitterUserEmail;
	public String TwitterUserPassword;
	public String Amazon_Web_Testing_URL;
	public String Amazon_App_Testing_URL;
	public String Amazon_Web_Production_URL;
	public String Amazon_App_Production_URL;
	
	
	public String EMmaximumNumberWeightLbs;
	public String EMmaximumNumberHeightFt;
	public String EMmaximumNumberHeightIn;
	public String EMascendingOrderRequire;
	public String EMonlyLettersFirstName;
	public String EMshortLengthFirstName;
	public String EMincorrectCredentials;
	public String EMnewPasswordRequiered;
	public String EMwrongCurrentPassword;
	public String EMRHRIsLessThenRequire;
	public String EMRHRIsMoreThenRequire;
	public String EMshortLengthLastName;
	public String EMminimumNumberHeight;
	public String EMminimumNumberWeight;
	public String EMonlyLettersLastName;
	public String EMmaximumNumberHeight;
	public String EMmaximumNumberWeight;
	public String EMoldPasswordRequired;
	public String EMrequiredFirstName;
	public String EMwrongDataInHRZBox;
	public String EMrequiredLastName;
	public String EMpasswordRequired;
	public String EMpasswordNotMatch;
	public String EMinvalidPassword;
	public String EMconfirmRequired;
	public String EMwrongBirthdate;	
	public String EMprovideHeight;
	public String EMprovideWeight;
	public String EMinvalidEmail;
	public String EMuserNotFound;
	
	public String ChromeDriver;
	public String IEDriver;
	

	
	
	public void getPropertyFields() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src/parameters.properties");
			prop.load(input);
					
			/*Login Page*/
			PasswordField = prop.get("PasswordField").toString();
			EmailField = prop.get("UserEmailField").toString();
			
			UserPassword = prop.get("InputUserPassword").toString();
			UserEmail = prop.get("InputUserEmail").toString();
			
			/*ResetPasword Page*/
			ConfirmNewPasswordField = prop.get("ConfirmNewPasswordField").toString();
			NewPasswordField = prop.get("NewPasswordField").toString();
	
			/*GetStarted Page*/
			DefaultPoolLength = prop.get("DefaultPoolLength").toString();
			DateOfBirthField = prop.get("DateOfBirthField").toString();
			FirstNameField = prop.get("FirstNameField").toString();
			LastNameField = prop.get("LastNameField").toString();
			SignUpButton = prop.get("SignUpButton").toString();
			HeightField = prop.get("HeightField").toString();
			WeightField = prop.get("WeightField").toString();

			/*FaceBook*/
			FBUserEmail = prop.get("FBUserEmail").toString();
			
			/*Twitter*/
			TwitterUserEmail = prop.get("TwitterUserEmail").toString();
			TwitterUserPassword = prop.get("TwitterUserPassword").toString();
			
			/* URL's */
			GL_URL = prop.get("GL_URL").toString();
			Amazon_URL = prop.get("Amazon_URL").toString();
			Amazon_Web_Testing_URL = prop.get("Amazon_Web_Testing_URL").toString();
			Amazon_App_Testing_URL = prop.get("Amazon_App_Testing_URL").toString();
			Amazon_Web_Production_URL = prop.get("Amazon_Web_Production_URL").toString();
			Amazon_App_Production_URL = prop.get("Amazon_App_Production_URL").toString();
					
			/*Error messages*/
			EMmaximumNumberWeightLbs = prop.get("maximumNumberWeightLbs").toString();
			EMmaximumNumberHeightFt = prop.get("maximumNumberHeightFt").toString();
			EMmaximumNumberHeightIn = prop.get("maximumNumberHeightIn").toString();
			EMascendingOrderRequire = prop.get("ascendingOrderRequire").toString();
			EMshortLengthFirstName = prop.get("shortLengthFirstName").toString();
			EMonlyLettersFirstName = prop.get("onlyLettersFirstName").toString();
			EMincorrectCredentials = prop.get("incorrectCredentials").toString();
			EMnewPasswordRequiered = prop.get("newPasswordRequiered").toString();
			EMwrongCurrentPassword = prop.get("wrongCurrentPassword").toString();
			EMRHRIsLessThenRequire = prop.get("RHRIsLessThenRequire").toString();
			EMRHRIsMoreThenRequire = prop.get("RHRIsMoreThenRequire").toString();
			EMshortLengthLastName = prop.get("shortLengthLastName").toString();
			EMonlyLettersLastName = prop.get("onlyLettersLastName").toString();
			EMminimumNumberHeight = prop.get("minimumNumberHeight").toString();
			EMminimumNumberWeight = prop.get("minimumNumberWeight").toString();
			EMmaximumNumberHeight = prop.get("maximumNumberHeight").toString();
			EMmaximumNumberWeight = prop.get("maximumNumberWeight").toString();			
			EMoldPasswordRequired = prop.get("oldPasswordRequired").toString();			
			EMrequiredFirstName = prop.get("requiredFirstName").toString();
			EMwrongDataInHRZBox = prop.get("wrongDataInHRZBox").toString();
			EMpasswordNotMatch = prop.get("passwordNotMatch").toString();
			EMpasswordRequired = prop.get("passwordRequired").toString();
			EMrequiredLastName = prop.get("requiredLastName").toString();
			EMinvalidPassword = prop.get("invalidPassword").toString();
			EMconfirmRequired = prop.get("confirmRequired").toString();
			EMwrongBirthdate = prop.get("wrongBirthdate").toString();
			EMprovideHeight = prop.get("provideHeight").toString();
			EMprovideWeight = prop.get("provideWeight").toString();
			EMinvalidEmail = prop.get("invalidEmail").toString();
			EMuserNotFound = prop.get("userNotFound").toString();
			
			/*Drivers
			IEDriver = prop.get("IEDriver").toString();
			ChromeDriver = prop.get("ChromeDriver").toString();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
