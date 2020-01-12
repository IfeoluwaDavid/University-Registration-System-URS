package serverAppSide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instructor extends FacultyRole
{
	private String assistant; 

	public Instructor(FacultyMember facultymember)
	{
	  super(facultymember);
	  this.assistant = "No Assistant Yet";
	  facultymember.getFacultyRoles().add(this);
	}

	public String getassistant() 
	{
		return assistant;
	}

	public void setassistant(String assistant)
	{
		this.assistant = assistant;
	}
	
	public static String postGrades(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();

		Course course = null;
		String grade;
		String studentID;
		
		for( int p=0 ; p<listOfFaculties.size(); p++)
		{
			int numberOfFacultyDepartments = listOfFaculties.get(p).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(clientInfoArray[1].equals(listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject()))
					{
						course = listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().get(k);
					}
				}
			}
		}
		
		if (!course.equals(null))
		{
			for (int i=2; i<clientInfoArray.length; i++)
			{
				studentID = clientInfoArray[i].substring(0, Math.min(clientInfoArray[i].length(), 6));
				grade = clientInfoArray[i].substring(clientInfoArray[i].length() - 1);
				
				for (int p = 0; p < listOfFaculties.size(); p++) 
				{
					int numberOfFacultyDepartments = listOfFaculties.get(p).getFacultyDepartments().size();
					
					for(int j=0; j<numberOfFacultyDepartments; j++)
					{
						int numberOfDepartmentStudents = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().size();
						
						for(int k=0; k<numberOfDepartmentStudents; k++)
						{
							if(studentID.equals(String.valueOf(listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
							{
								ArrayList<Registration> studentRegistration = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration();
								int noOfRegistrations = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().size();
								
								for (int m=0; m<noOfRegistrations; m++)
								{
									if(studentRegistration.get(m).getCourse().getCourseSubject().equals(course.getCourseSubject()))
									{
										studentRegistration.get(m).setGrade(grade);
										
										for(int q=0; q<course.getRegistrationList().size(); q++)
										{
											if(course.getRegistrationList().get(q).getStudent().getMemberID() == Integer.parseInt(studentID))
											{
												course.getRegistrationList().get(q).setGrade(grade);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return "postGradesSuccess";
		}
		else
		{
			return "postGradesFailure";
		}
	}
	
	public static ArrayList<String> viewCourseGrades(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfCourseGrades = new ArrayList<String>();
		listOfCourseGrades.add(clientInfoArray[0]);
		listOfCourseGrades.add(clientInfoArray[1]);
		listOfCourseGrades.add(clientInfoArray[2]);
		
		Course course = null;
		
		for( int p=0 ; p<listOfFaculties.size(); p++)
		{
			int numberOfFacultyDepartments = listOfFaculties.get(p).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(clientInfoArray[2].equals(listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject()))
					{
						course = listOfFaculties.get(p).getFacultyDepartments().get(j).getCourses().get(k);
					}
				}
			}
		}
		
		if(!course.equals(null))
		{
			for(int q=0; q<course.getRegistrationList().size(); q++)
			{
				System.out.println(course.getRegistrationList().get(q).toString());
				if(!course.getRegistrationList().get(q).getGrade().equals("IP"))
				{
					listOfCourseGrades.add(course.getRegistrationList().get(q).toString());
				}
			}
		}
		
		return listOfCourseGrades;
	}
}