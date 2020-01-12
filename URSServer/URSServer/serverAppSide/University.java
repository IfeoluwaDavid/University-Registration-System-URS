package serverAppSide;

import java.util.*;

import com.sun.corba.se.spi.activation.Server;

public class University 
{
	public static ArrayList<Faculty> faculties = new ArrayList<Faculty>();
	public static ArrayList<StaffMember> Staff = new ArrayList<StaffMember>();
	
	public static Faculty newfaculty1 = new Faculty("Faculty of Business Administration");
	public static Faculty newfaculty2 = new Faculty("Faculty of Education");
	public static Faculty newfaculty3 = new Faculty("Faculty of Engineering");
	public static Faculty newfaculty4 = new Faculty("Faculty of Graduate Studies");
	public static Faculty newfaculty5 = new Faculty("Faculty of Health and Behavioural Sciences");
	public static Faculty newfaculty6 = new Faculty("Faculty of Law");
	public static Faculty newfaculty7 = new Faculty("Faculty of Medical School");
	public static Faculty newfaculty8 = new Faculty("Faculty of Natural Rescources and Management");
	public static Faculty newfaculty9 = new Faculty("Faculty of Science and Environmental Studies");
	public static Faculty newfaculty10 = new Faculty("Faculty of Social Sciences and Humanities");

	public static ArrayList<Faculty> getFaculties()
	{
		faculties.clear();
		
		faculties.add(newfaculty1);
		faculties.add(newfaculty2);
		faculties.add(newfaculty3);
		faculties.add(newfaculty4);
		faculties.add(newfaculty5);
		faculties.add(newfaculty6);
		faculties.add(newfaculty7);
		faculties.add(newfaculty8);
		faculties.add(newfaculty9);
		faculties.add(newfaculty10);
		
		return faculties;
	}
	
	public static ArrayList<StaffMember> getStaff()
	{
		return Staff;
	}
	
	public static ArrayList<String> getFacultyNames(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		ArrayList<String> listOfFacultiesNames = new ArrayList<String>();
		listOfFacultiesNames.add(clientInfoArray[0]);
		listOfFacultiesNames.add(clientInfoArray[1]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			listOfFacultiesNames.add(listOfFaculties.get(i).getFacultyName());
		}
		
		return listOfFacultiesNames;
	}
	
	public static Faculty getSpecificFaculty(String facultyName)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
            if(listOfFaculties.get(i).getFacultyName().equals(facultyName))
            {
                return listOfFaculties.get(i);
            }
		}
		return null;
	}	
	
	public static ArrayList<String> getFacultyDepartments(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		ArrayList<String> listOfFacultyDepartments = new ArrayList<String>();
		listOfFacultyDepartments.add(clientInfoArray[0]);
		listOfFacultyDepartments.add(clientInfoArray[1]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			if(clientInfoArray[2].equals(listOfFaculties.get(i).getFacultyName()))
			{
				int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
				for(int j = 0; j < numberOfFacultyDepartments; j++)
				{
					listOfFacultyDepartments.add(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName());
				}
			}
		}
		return listOfFacultyDepartments;
	}
	
	public static ArrayList<String> getDepartments(String[] clientInfoArray)
	{
		List<Faculty> listOfFaculties = getFaculties();
		ArrayList<String> listOfDepartments = new ArrayList<String>();
		listOfDepartments.add(clientInfoArray[0]);
		listOfDepartments.add(clientInfoArray[1]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			for(int j = 0; j < numberOfFacultyDepartments; j++)
			{
				listOfDepartments.add(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName());
			}
		}
		return listOfDepartments;
	}
	
	public static Department getSpecificDepartment(String departmentName)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();

			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName().equals(departmentName))
				{
					return listOfFaculties.get(i).getFacultyDepartments().get(j);
				}
			}
		}
		return null;
	}
	
	public static ArrayList<String> getSpecificDepartmentCourses(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		
		ArrayList<String> listOfDepartmentCourses = new ArrayList<String>();
		listOfDepartmentCourses.add(clientInfoArray[0]);
		listOfDepartmentCourses.add(clientInfoArray[1]);
		listOfDepartmentCourses.add(clientInfoArray[2]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(clientInfoArray[2].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName()))
				{
					int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
					
					for(int k=0; k<numberOfDepartmentCourses; k++)
					{
						String coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
						String coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
						String coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
						String course = coursecode +" "+ coursenumber + " - " + coursesubject;
						listOfDepartmentCourses.add(course);
					}
				}
			}
		}
		return listOfDepartmentCourses;
	}
	
	public static ArrayList<String> getSpecificDepartmentInfo(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		
		ArrayList<String> listOfDepartmentInfo = new ArrayList<String>();
		listOfDepartmentInfo.add(clientInfoArray[0]);
		listOfDepartmentInfo.add(clientInfoArray[1]);
		listOfDepartmentInfo.add(clientInfoArray[2]);
		
		String firstname, lastname, memberid, chair;
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(clientInfoArray[2].equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName()))
				{
					listOfDepartmentInfo.add(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDuration()));
					listOfDepartmentInfo.add(listOfFaculties.get(i).getFacultyDepartments().get(j).getFaculty().getFacultyName());
					
					if(listOfFaculties.get(i).getFacultyDepartments().get(j).getChair() == null)
					{
						chair = "Unassigned";
						listOfDepartmentInfo.add(chair);
					}
					else
					{
						firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getChair().getFacultyMember().getfirstName();
						lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getChair().getFacultyMember().getlastName();
						memberid = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getChair().getFacultyMember().getMemberID());
						chair = firstname +" "+ lastname +" - "+ memberid;
						listOfDepartmentInfo.add(chair);
					}
				}
			}
		}
		return listOfDepartmentInfo;
	}
	
	public static ArrayList<String> getCourseInfo(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		
		ArrayList<String> courseObjectInfo = new ArrayList<String>();
		courseObjectInfo.add(clientInfoArray[0]);
		courseObjectInfo.add(clientInfoArray[1]);
		
		String instructor;
		
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
						String description = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getDescription();
						String subject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
						String code = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();
						String number = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
						String capacity = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCapacity());
						String department = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getDepartment();
						String semester = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getSemester();
						String yearlevel = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getYearlevel());
						String enrollmentcount = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getEnrollmentCount());
						
						Instructor courseinstructor = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getInstructor();
						
						if(courseinstructor == null)
						{
							instructor = "Unassigned";
						}
						else
						{
							String firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getInstructor().getFacultyMember().getfirstName();
							String lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getInstructor().getFacultyMember().getlastName();
							String memberid = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getInstructor().getFacultyMember().getMemberID());
							instructor = firstname + " " + lastname + " - " + memberid;
						}

						courseObjectInfo.add(description);
						courseObjectInfo.add(subject);
						courseObjectInfo.add(code);
						courseObjectInfo.add(number);
						courseObjectInfo.add(capacity);
						courseObjectInfo.add(department);
						courseObjectInfo.add(semester);
						courseObjectInfo.add(yearlevel);
						courseObjectInfo.add(instructor);
						courseObjectInfo.add(enrollmentcount);
					}
				}
			}
		}
		return courseObjectInfo;
	}
	
	public static ArrayList<String> getAllCourses(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = getFaculties();
		
		ArrayList<String> listOfAllCourses = new ArrayList<String>();
		listOfAllCourses.add(clientInfoArray[0]);
		listOfAllCourses.add(clientInfoArray[1]);
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					String coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject();
					String coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseNumber());
					String coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseCode();				
					String course = coursecode +" "+ coursenumber + " - " + coursesubject;
					listOfAllCourses.add(course);
				}
			}
		}
		return listOfAllCourses;
	}
}
