package clientAppSide;
import java.util.ArrayList;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

public class Validation
{
	public static boolean isValidEmailAddress(String email) 
	{
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public static boolean validateLetters(String name) {

	    String regx = "^[a-zA-Z\\s]+$";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    java.util.regex.Matcher matcher = pattern.matcher(name);
	    return matcher.find();
	}
	
	public static boolean validateHomeAddress( String address )
	   {
	      return address.matches( 
	         "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
	   } 
	
	public static Boolean checkEmptyFields(ArrayList<String> inputData)
	{
		for (int i = 0; i < inputData.size(); i++)
		{
			if(inputData.get(i).isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	public static String validateCreateDepartment(ArrayList<String> fields)
	{
		if(!checkEmptyFields(fields))
		{
			return "incomplete";
		}
		else
		{
			for (int i = 0; i < fields.size(); i++)
			{
				if(!fields.get(1).matches("^[ A-Za-z]+$"))
				{
					return "departmentNameProblem";
				}
				
				if(fields.get(2).matches("[a-zA-Z]+") || Integer.parseInt(fields.get(2)) > 5)
				{
					return "durationProblem";
				}
			}
			return "valid";
		}
	}

	public static String validateRegisterStudent(ArrayList<String> fields)
	{
		if(!checkEmptyFields(fields))
		{
			return "incomplete";
		}
		else
		{
			for (int i = 0; i < fields.size(); i++)
			{
				if(!fields.get(1).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "firstNameIssue";
				}
				if(!fields.get(2).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "lastNameIssue";
				}
				if(!fields.get(3).matches("^[A-Za-z0-9+_.-]+@(.+)$"))
				{
					return "emailIssue";
				}
				if(!fields.get(12).matches("^\\d{6}$"))
				{
					return "idIssue";
				}
				if(!fields.get(8).matches("^\\d{6}$"))
				{
					return "sinIssue";
				}
				if(!fields.get(4).matches("\\d{1,3}.?\\d{0,3}\\s[a-zA-Z]{2,30}\\s[a-zA-Z]{2,15}"))
				{
					return "addressIssue";
				}
			}
			return "valid";
		}
	}
	
	public static String validateRegisterFaculty(ArrayList<String> field)
	{
		if(!checkEmptyFields(field))
		{
			return "incomplete";
		}
		else
		{
			for (int i = 0; i < field.size(); i++)
			{
				if(!field.get(1).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "firstNameIssue";
				}
				if(!field.get(2).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "lastNameIssue";
				}
				if(!field.get(3).matches("^[A-Za-z0-9+_.-]+@(.+)$"))
				{
					return "emailIssue";
				}
				if(!field.get(4).matches("\\d{1,3}.?\\d{0,3}\\s[a-zA-Z]{2,30}\\s[a-zA-Z]{2,15}"))
				{
					return "addressIssue";
				}
				if(!field.get(8).matches("^\\d{6}$"))
				{
					return "sinIssue";
				}
				if(!field.get(12).matches("^\\d{6}$"))
				{
					return "idIssue";
				}
			}
			return "valid";
		}
	}
	
	public static String validateRegisterStaff(ArrayList<String> input)
	{
		if(!checkEmptyFields(input))
		{
			return "incomplete";
		}
		else
		{
				if(!input.get(1).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "firstNameIssue";
				}
				if(!input.get(2).matches("[a-zA-Z][a-zA-Z]*"))
				{
					return "lastNameIssue";
				}
				if(!input.get(3).matches("^[A-Za-z0-9+_.-]+@(.+)$"))
				{
					return "emailIssue";
				}
				if(!input.get(4).matches("\\d{1,3}.?\\d{0,3}\\s[a-zA-Z]{2,30}\\s[a-zA-Z]{2,15}"))
				{
					return "addressIssue";
				}
				if(!input.get(8).matches("^\\d{6}$"))
				{
					return "sinIssue";
				}
				if(!input.get(12).matches("^\\d{6}$"))
				{
					return "idIssue";
				}
			
			return "valid";
		}
	}
	
	public static String validateCreateCourse(ArrayList<String> input)
	{
		if(!checkEmptyFields(input))
		{
			return "incomplete";
		}
		else
		{
			if(!input.get(1).matches("^[ A-Za-z]+$"))
			{
				return "courseSubjectIssue";
			}
			if(!input.get(2).matches("^[A-Za-z]{4}$"))
			{
				return "courseCodeIssue";
			}
			if(!input.get(3).matches("^[0-9]{4}$"))
			{
				return "courseNumberIssue";
			}
			if(!input.get(7).matches("^[0-9]*$"))
			{
				return "capacityIssue";
			}
			return "valid";
		}
	}
	
	public static String validateSearchCourse(ArrayList<String> input)
	{
		if(!checkEmptyFields(input))
		{
			return "incomplete";
		}
		else
		{
			return "valid";
		}
	}
	
	public static String validateSearchMember(ArrayList<String> input)
	{
		if(!checkEmptyFields(input))
		{
			return "incomplete";
		}
		else
		{
			return "valid";
		}
	}
	/*public static Boolean validateIPAddress(String input)
	{
		if(input.equals("localhost"))
		{
			return true;
		}
		else if(!input.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"))
		{
			return false;
		}
		else
		{
			return false;
		}
	}*/
	public static Boolean isNumeric(String value) 
	{
	    if (value.matches("^[0-9]+$")) 
	    {
	        return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}
