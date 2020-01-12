package serverAppSide;

import java.util.*;
import java.io.*;

public class Member 
{
	private String firstName, lastName, email, address, password, dateOfBirth;
	private int memberID, sinNumber;
	
	/**********************************/
	 
	public Member(String firstName, String lastName, int memberID, String email, String dateOfBirth, int sinNumber, String address, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.memberID = memberID;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.sinNumber = sinNumber;
		this.address = address;
		this.password = password;
	}
	
	/***********************************************************************/
	
	public void setfirstName(String newFirstName)
	{
	  this.firstName = newFirstName;
	}
	
	public String getfirstName() 
	{
	  return firstName;
	}
	
	/***********************************************************************/
	
	public void setlastName(String newLastName)
	{
	  this.lastName = newLastName;
	}
	
	public String getlastName() 
	{
	  return lastName;
	}
	
	/***********************************************************************/
	
	public void setMemberID(int newMemberID)
	{
	  this.memberID = newMemberID;
	}
	
	public int getMemberID() 
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

	public void setDateOfBirth(String newDateOfBirth)
	{
	  this.dateOfBirth = newDateOfBirth;
	}
	
	public String getDateOfBirth() 
	{
	  return dateOfBirth;
	}
	
	/***********************************************************************/
	
	public void setSinNumber(int newSINnumber)
	{
	  this.sinNumber = newSINnumber;
	}
	
	public int getSinNumber() 
	{
	  return sinNumber;
	}
	
	/***********************************************************************/
	
	public void setAddress(String newAddress)
	{
	  this.address = newAddress;
	}
	
	public String getAddress() 
	{
	  return address;
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
	   return firstName + ", " + lastName + ", " + memberID + ", " + email + ", " + dateOfBirth + ", " + sinNumber + ", " + address + ", " + password; 
	}
	
	/***********************************************************************/
	
	public static ArrayList<String> login(String memberID, String password)
	{
		ArrayList<String> userInfo = new ArrayList<String>();
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		String operationFeedback, firstname, lastname, usertype, email, department;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(memberID.equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						if(password.equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getPassword()))
						{
							operationFeedback = "LoginSuccess";
							usertype = "studentmember";
							firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
							lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
							email = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getEmail();
							
							userInfo.add(operationFeedback);
							userInfo.add(firstname);
							userInfo.add(lastname);
							userInfo.add(email);
							userInfo.add(memberID);
							userInfo.add(usertype);
							
							return userInfo;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
			
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				if(memberID.equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())))
				{
					if(password.equals(listOfFaculties.get(i).getFacultyMembers().get(k).getPassword()))
					{
						operationFeedback = "LoginSuccess";
						firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
						lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
						email = listOfFaculties.get(i).getFacultyMembers().get(k).getEmail();
						
						userInfo.add(operationFeedback);
						userInfo.add(firstname);
						userInfo.add(lastname);
						userInfo.add(email);
						userInfo.add(memberID);
						
						int numberOfFacultyRoles = listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().size();
						HashSet<String> roles = new HashSet<String>();
						
						if(!listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().isEmpty())
						{
							for(int m=0; m<numberOfFacultyRoles; m++)
							{
								if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(m) instanceof Instructor)
								{
									roles.add("Instructor");
								}
								else if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(m) instanceof Chair)
								{
									roles.add("Chair");
								}
								else
								{
									// Do nothing
								}
							}
							if(roles.contains("Chair"))
							{
								usertype = "facultyChair";
								department = listOfFaculties.get(i).getFacultyMembers().get(k).getDepartment().getDepartmentName();
								userInfo.add(usertype);
								userInfo.add(department);
							}
							else
							{
								usertype = "facultyInstructor";
								userInfo.add(usertype);
							}
						}
						else
						{
							usertype = "noRoleFaculty";
							userInfo.add(usertype);
						}
						
						return userInfo;
					}
				}
			}
		}
		
		ArrayList<StaffMember> listOfStaff = University.getStaff();
		for(int k=0; k<listOfStaff.size(); k++)
		{
			if(memberID.equals(String.valueOf(listOfStaff.get(k).getMemberID())))
			{
				if(password.equals(listOfStaff.get(k).getPassword()))
				{
					operationFeedback = "LoginSuccess";
					usertype = "staffmember";
					firstname = listOfStaff.get(k).getfirstName();
					lastname = listOfStaff.get(k).getlastName();
					email = listOfStaff.get(k).getEmail();
					
					userInfo.add(operationFeedback);
					userInfo.add(firstname);
					userInfo.add(lastname);
					userInfo.add(email);
					userInfo.add(memberID);
					userInfo.add(usertype);
					
					return userInfo;
				}
			}
		}
		
		operationFeedback = "LoginFailure";
		userInfo.add(operationFeedback);
		return userInfo;
	}
	
	/***********************************************************************/
	
	public static ArrayList<String> viewCourseSchedules(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listofschedules = new ArrayList<String>();
		listofschedules.add(clientInfoArray[0]);
		listofschedules.add(clientInfoArray[1]);
		listofschedules.add(clientInfoArray[2]);
		
		String weekday, starttime, startmeridiem, endtime, endmeridiem, schedule;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(clientInfoArray[2].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject()))
					{
						int noOfCourseSchedules = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().size();
						
						for(int n=0; n<noOfCourseSchedules; n++)
						{
							weekday = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().get(n).getWeekday();
							starttime = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().get(n).getStartTime();
							startmeridiem = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().get(n).getStartMeridiem();
							endtime = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().get(n).getEndTime();
							endmeridiem = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSchedule().get(n).getEndMeridiem();
							schedule = weekday + " - ["+ starttime +""+ startmeridiem +" - "+ endtime +""+ endmeridiem +"]";
							listofschedules.add(schedule);
						}
					}
				}
			}
		}
		return listofschedules;
	}
	
	/***********************************************************************/
	
	public static ArrayList<String> searchCourses(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfMatches = new ArrayList<String>();
		listOfMatches.add(clientInfoArray[0]);
		listOfMatches.add(clientInfoArray[1]);
		
		String coursesubject, coursenumber, coursecode, course;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(clientInfoArray[2].equals("Course Subject"))
					{
						if(clientInfoArray[3].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject()))
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listOfMatches.add(course);
						}
					}
					if(clientInfoArray[2].equals("Course Code"))
					{
						if(clientInfoArray[3].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode()))
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listOfMatches.add(course);
						}
					}
					if(clientInfoArray[2].equals("Course Number"))
					{
						if(clientInfoArray[3].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber())))
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listOfMatches.add(course);
						}
					}
					if(clientInfoArray[2].equals("Semester"))
					{
						if(clientInfoArray[3].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSemester()))
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listOfMatches.add(course);
						}
					}
					if(clientInfoArray[2].equals("Department"))
					{
						if(clientInfoArray[3].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getDepartment()))
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listOfMatches.add(course);
						}
					}
				}
			}
		}
		return listOfMatches;
	}
	
	/********************************************************************************/
	
	public static ArrayList<String> viewUserProfile(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> userInfo = new ArrayList<String>();
		userInfo.add(clientInfoArray[0]);
		userInfo.add(clientInfoArray[1]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						String firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
						String lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
						String email = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getEmail();
						String dateofbirth = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getDateOfBirth();
						String sinNumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getSinNumber());
						String address = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getAddress();
						String memberid = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID());
						String department = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getDepartment();
						String yearlevel = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getYearLevel());
						String membertype = "studentmember";
						
						
						AttendanceRole attendance = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getAttendanceRole();
						
						String attendanceRole;
						if(attendance instanceof PartTime)
						{
							attendanceRole = "Part-Time";
						}
						else if(attendance instanceof FullTime)
						{
							attendanceRole = "Full-Time";
						}
						else
						{
							attendanceRole = "Undetermined";
						}
						
						userInfo.add(firstname);
						userInfo.add(lastname);
						userInfo.add(email);
						userInfo.add(dateofbirth);
						userInfo.add(sinNumber);
						userInfo.add(address);
						userInfo.add(department);
						userInfo.add(yearlevel);
						userInfo.add(attendanceRole);
						userInfo.add(memberid);
						userInfo.add(membertype);
						
						return userInfo;
					}
				}
			}
		}
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
			
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())))
				{
					String firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
					String lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
					String email = listOfFaculties.get(i).getFacultyMembers().get(k).getEmail();
					String dateofbirth = listOfFaculties.get(i).getFacultyMembers().get(k).getDateOfBirth();
					String sinNumber = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getSinNumber());
					String status = listOfFaculties.get(i).getFacultyMembers().get(k).getStatus();
					String address = listOfFaculties.get(i).getFacultyMembers().get(k).getAddress();
					String position = listOfFaculties.get(i).getFacultyMembers().get(k).getPosition();
					String memberid = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
					String earning = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getEarning());
					String faculty = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getFaculty().getFacultyName());
					String membertype = "facultymember";
					
					int numberOfFacultyRoles = listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().size();
					ArrayList<String> roles = new ArrayList<String>();
					
					if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().isEmpty())
					{
						roles.add("No Roles Assigned");
					}
					else
					{
						for(int m=0; m<numberOfFacultyRoles; m++)
						{
							if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(m) instanceof Instructor)
							{
								roles.add("Instructor");
							}
							else if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(m) instanceof Chair)
							{
								roles.add("Chair");
							}
							else
							{
								//roles.add("");
							}
						}
					}
					
					Set<String> hashset = new HashSet<String>();
					hashset.addAll(roles);
					roles.clear();
					roles.addAll(hashset);
					
					String facultyRoles = roles.toString();
					facultyRoles = facultyRoles.substring(1);
					facultyRoles = facultyRoles.substring(0, facultyRoles.length()-1);
					
					userInfo.add(firstname);
					userInfo.add(lastname);
					userInfo.add(email);
					userInfo.add(dateofbirth);
					userInfo.add(sinNumber);
					userInfo.add(status);
					userInfo.add(address);
					userInfo.add(position);
					userInfo.add(earning);
					userInfo.add(faculty);
					userInfo.add(memberid);
					userInfo.add(facultyRoles);
					userInfo.add(membertype);
					
					return userInfo;
				}
			}
		}
		
		ArrayList<StaffMember> listOfStaff = University.getStaff();
		for(int k=0; k<listOfStaff.size(); k++)
		{
			if(clientInfoArray[2].equals(String.valueOf(listOfStaff.get(k).getMemberID())))
			{
				String firstname = listOfStaff.get(k).getfirstName();
				String lastname = listOfStaff.get(k).getlastName();
				String email = listOfStaff.get(k).getEmail();
				String dateofbirth = listOfStaff.get(k).getDateOfBirth();
				String sinNumber = String.valueOf(listOfStaff.get(k).getSinNumber());
				String status = listOfStaff.get(k).getStatus();
				String address = listOfStaff.get(k).getAddress();
				String position = listOfStaff.get(k).getPosition();
				String memberid = String.valueOf(listOfStaff.get(k).getMemberID());
				String earning = String.valueOf(listOfStaff.get(k).getEarning());
				String qualification = String.valueOf(listOfStaff.get(k).getQualification());
				String membertype = "staffmember";
				
				userInfo.add(firstname);
				userInfo.add(lastname);
				userInfo.add(email);
				userInfo.add(dateofbirth);
				userInfo.add(sinNumber);
				userInfo.add(status);
				userInfo.add(address);
				userInfo.add(position);
				userInfo.add(earning);
				userInfo.add(qualification);
				userInfo.add(memberid);
				userInfo.add(membertype);
				
				return userInfo;
			}
		}
		return userInfo;
	}
	
	public static ArrayList<String> editUserProfile(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> newLoggedInClientUserInfo = new ArrayList<String>();
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			if(clientInfoArray[7].equals("studentmember"))
			{
				for(int j=0; j<numberOfFacultyDepartments; j++)
				{
					int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
					
					for(int k=0; k<numberOfDepartmentStudents; k++)
					{
						if(clientInfoArray[1].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
						{
							listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).setfirstName(clientInfoArray[2]);
							listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).setlastName(clientInfoArray[3]);
							listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).setEmail(clientInfoArray[4]);
							listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).setSinNumber(Integer.parseInt(clientInfoArray[5]));
							listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).setAddress(clientInfoArray[6]);
							
							String operationFeedback = "editProfileSuccess";
							String firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
							String lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
							String email = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getEmail();
							
							newLoggedInClientUserInfo.add(operationFeedback);
							newLoggedInClientUserInfo.add(firstname);
							newLoggedInClientUserInfo.add(lastname);
							newLoggedInClientUserInfo.add(email);
							
							return newLoggedInClientUserInfo;
						}
					}
				}
			}
			else if(clientInfoArray[7].equals("facultyChair") || clientInfoArray[7].equals("facultyInstructor"))
			{
				int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
				
				for(int k=0; k<numberOfFacultyMembers; k++)
				{
					if(clientInfoArray[1].equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())))
					{
						listOfFaculties.get(i).getFacultyMembers().get(k).setfirstName(clientInfoArray[2]);
						listOfFaculties.get(i).getFacultyMembers().get(k).setlastName(clientInfoArray[3]);
						listOfFaculties.get(i).getFacultyMembers().get(k).setEmail(clientInfoArray[4]);
						listOfFaculties.get(i).getFacultyMembers().get(k).setSinNumber(Integer.parseInt(clientInfoArray[5]));
						listOfFaculties.get(i).getFacultyMembers().get(k).setAddress(clientInfoArray[6]);
						
						String operationFeedback = "editProfileSuccess";
						String firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
						String lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
						String email = listOfFaculties.get(i).getFacultyMembers().get(k).getEmail();
						
						newLoggedInClientUserInfo.add(operationFeedback);
						newLoggedInClientUserInfo.add(firstname);
						newLoggedInClientUserInfo.add(lastname);
						newLoggedInClientUserInfo.add(email);
						
						return newLoggedInClientUserInfo;
					}
				}
			}
			else
			{
				//do nothing
			}
		}
		if(clientInfoArray[7].equals("staffmember"))
		{
			ArrayList<StaffMember> listOfStaff = University.getStaff();
			
			for(int k=0; k<listOfStaff.size(); k++)
			{
				if(clientInfoArray[1].equals(String.valueOf(listOfStaff.get(k).getMemberID())))
				{
					listOfStaff.get(k).setfirstName(clientInfoArray[2]);
					listOfStaff.get(k).setlastName(clientInfoArray[3]);
					listOfStaff.get(k).setEmail(clientInfoArray[4]);
					listOfStaff.get(k).setSinNumber(Integer.parseInt(clientInfoArray[5]));
					listOfStaff.get(k).setAddress(clientInfoArray[6]);
					
					String operationFeedback = "editProfileSuccess";
					String firstname = listOfStaff.get(k).getfirstName();
					String lastname = listOfStaff.get(k).getlastName();
					String email = listOfStaff.get(k).getEmail();
					
					newLoggedInClientUserInfo.add(operationFeedback);
					newLoggedInClientUserInfo.add(firstname);
					newLoggedInClientUserInfo.add(lastname);
					newLoggedInClientUserInfo.add(email);
					
					return newLoggedInClientUserInfo;
				}
			}
		}
		String operationFeedback = "editProfileFailure";
		newLoggedInClientUserInfo.add(operationFeedback);
		return newLoggedInClientUserInfo;
	}
}