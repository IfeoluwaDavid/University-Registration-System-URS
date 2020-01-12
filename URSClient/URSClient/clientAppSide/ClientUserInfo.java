package clientAppSide;

import java.util.*;
import java.io.*;

public class ClientUserInfo 
{
	private String firstname, lastname, email, password, usertype, department;
	private String memberID = "";
	private Boolean loginStatus = false;
	static ClientUserInfo user;
	
	public ClientUserInfo()
	{
		user = this;
		this.usertype = "publicuser";
	}
	
	/*************************************************************/

	public ClientUserInfo(String usertype, String firstname, String lastname, String email, String memberID)
	{
			user = this;
			this.usertype = usertype;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.memberID = memberID;
	}
	
	/***********************************************************************/
	
	public void setfirstName(String newFirstName)
	{
	  this.firstname = newFirstName;
	}
	
	public String getfirstName() 
	{
	  return firstname;
	}
	
	/***********************************************************************/
	
	public void setlastName(String newLastName)
	{
	  this.lastname = newLastName;
	}
	
	public String getlastName() 
	{
	  return lastname;
	}
	
	/***********************************************************************/
	
	public void setMemberID(String newMemberID)
	{
	  this.memberID = newMemberID;
	}
	
	public String getMemberID() 
	{
	  return memberID;
	}
	
	/***********************************************************************/
	
	public void setEmail(String newEmail)
	{
	  this.email = newEmail;
	}
	
	public String getEmail() 
	{
	  return email;
	}
	
	/***********************************************************************/
	
	public void setPassword(String newPassword)
	{
	  this.password = newPassword;
	}
	
	public String getPassword() 
	{
	  return password;
	}
	
	/***********************************************************************/

	public String toString() 
	{
	   return firstname + ", " + lastname + ", " + memberID + ", " + email + ", " + password; 
	}

	/***********************************************************************/
	
	public String getUserType()
	{
		return usertype;
	}

	public void setUserType(String usertype)
	{
		this.usertype = usertype;
	}

	/***********************************************************************/
	
	public Boolean getLoginStatus()
	{
		return loginStatus;
	}

	public void setLoginStatus(Boolean loginStatus)
	{
		this.loginStatus = loginStatus;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	/***********************************************************************/
}