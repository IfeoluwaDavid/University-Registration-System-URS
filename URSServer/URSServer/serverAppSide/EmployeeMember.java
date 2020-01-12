package serverAppSide;

import java.util.ArrayList;

public class EmployeeMember extends Member
{
	private String position;
	private String status;
	private int earning;
	
	public EmployeeMember(String firstName, String lastName, int memberID, String email, String dateofbirth, int sinNumber, 
					String address, String password, String status, String position, int earning)
	{
		super(firstName, lastName, memberID, email, dateofbirth, sinNumber, address, password);
		this.setStatus(status);
		this.position = position;//when creating employee position is unassigned, but can be modified later by the staff member
		this.earning = earning; //when creating employee earning is 0, but can be modified later by the staff member
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public int getEarning()
	{
		return earning;
	}

	public void setEarning(int earning)
	{
		this.earning = earning;
	}
	
	public String toString()
	{
		String memberInfo = super.toString();
     	return memberInfo + ", " + position + ", " + earning;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public static ArrayList<String> viewCourseEnrolledStudents(String[] clientInfoArray)
	{
		ArrayList<String> listOfEnrolledStudents = new ArrayList<String>();
		try
		{
			ArrayList<Faculty> listOfFaculties = University.getFaculties();
			listOfEnrolledStudents.add(clientInfoArray[0]);
			listOfEnrolledStudents.add(clientInfoArray[1]);
			listOfEnrolledStudents.add(clientInfoArray[2]);
			
			String firstname, lastname, memberid, student;
			
			for (int i = 0; i < listOfFaculties.size(); i++) 
			{	
				int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
				
				for(int j=0; j<numberOfFacultyDepartments; j++)
				{
					int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
					
					for(int k=0; k<numberOfDepartmentCourses; k++)
					{
						if(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject().equals(clientInfoArray[2]))
						{
							int numberOfEnrolledStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getRegistrationList().size();
							
							for(int m=0; m<numberOfEnrolledStudents; m++)
							{
								firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getRegistrationList().get(m).getStudent().getfirstName();
								lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getRegistrationList().get(m).getStudent().getlastName();
								memberid = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getRegistrationList().get(m).getStudent().getMemberID());
								student = firstname +" "+ lastname + " - " + memberid;
								listOfEnrolledStudents.add(student);
							}
						}
					}
				}
			}
			return listOfEnrolledStudents;
		}
		catch(Exception e)
		{
			ServerUI.displayActivities(e.getMessage());
			return listOfEnrolledStudents;
		}
		
	}
	
	

	public static ArrayList<String> viewAssignedCourses(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfAssignedCourses = new ArrayList<String>();
		listOfAssignedCourses.add(clientInfoArray[0]);
		listOfAssignedCourses.add(clientInfoArray[1]);
		listOfAssignedCourses.add(clientInfoArray[2]);
		
		String coursecode, coursenumber, coursename, course;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
	
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())))
				{
					int numberOfAssignedCourses = listOfFaculties.get(i).getFacultyMembers().get(k).getAssignedCourses().size();
					
					for(int m=0; m<numberOfAssignedCourses; m++)
					{
						coursecode = listOfFaculties.get(i).getFacultyMembers().get(k).getAssignedCourses().get(m).getCourseCode();
						coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getAssignedCourses().get(m).getCourseNumber());
						coursename = listOfFaculties.get(i).getFacultyMembers().get(k).getAssignedCourses().get(m).getCourseSubject();
						course = coursecode +" "+ coursenumber + " - " + coursename;
						listOfAssignedCourses.add(course);
					}
				}
			}
		}
		return listOfAssignedCourses;
	}
}