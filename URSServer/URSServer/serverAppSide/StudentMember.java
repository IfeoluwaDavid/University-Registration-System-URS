package serverAppSide;

import java.util.ArrayList;
import java.util.List;

public class StudentMember extends Member
{
	private AttendanceRole attendanceRole;
	private Department department;
	private int yearlevel;
	private ArrayList<Registration> registration;
   
	public StudentMember(String firstName, String lastName, int memberID, String email, String dateOfBirth,
				   int sinNumber, String address, String password, Department department, int yearlevel)
	{
		super(firstName, lastName, memberID, email, dateOfBirth, sinNumber, address, password);
		this.attendanceRole = null;
		this.department = department;
		this.yearlevel = yearlevel;
		this.setRegistration(new ArrayList<Registration>());
		department.getDepartmentStudents().add(this);
	}
	
	public String toString()
	{
		String memberInfo = super.toString();
		return memberInfo + ", " + department + ", " + yearlevel + "\n";
	}
	
	/***********************************************************************/
	
	public void setDepartment(Department newdepartment)
	{
	  this.department = newdepartment;
	}
	
	public String getDepartment() 
	{
	  return department.getDepartmentName();
	}
	
	/***********************************************************************/
	
	public void setYearLevel(int newYearLevel)
	{
	  this.yearlevel = newYearLevel;
	}
	
	public int getYearLevel() 
	{
	  return yearlevel;
	}
	
	/***********************************************************************/

	public ArrayList<Registration> getRegistration()
	{
		return registration;
	}

	public void setRegistration(ArrayList<Registration> registration)
	{
		this.registration = registration;
	}

	/***********************************************************************/
	
	public AttendanceRole getAttendanceRole()
	{
		return attendanceRole;
	}

	public void setAttendanceRole(AttendanceRole attendanceRole)
	{
		this.attendanceRole = attendanceRole;
	}
	
	/***********************************************************************/
	
	public static String registerCourse(String selectedCourse, String memberID)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		Course course = null;
		String defaultGrade = "IP";
		StudentMember student = null;
		
		for (int i = 0; i < listOfFaculties.size(); i++)
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(selectedCourse.equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject()))
					{
						course = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k);
					}
				}
			}
		}
		
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
						student = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k);
					}
				}
			}
		}
		
		if(student.equals(null) || course.equals(null))
		{
			return "registerCourseNotFound";
		}
		int noOfRegisteredCourses = student.getRegistration().size();
		for (int i=0; i<noOfRegisteredCourses; i++)
		{
			if(student.getRegistration().get(i).getCourse().toString().equals(course.toString()))
			{
				return "registerCourseDuplicate";
			}
		}
		if(course.getEnrollmentCount() >= course.getCapacity())
		{
			return "registerCourseFilledUp";
		}
		else
		{
			if (course.getYearlevel() != student.getYearLevel())
			{
				return "registerCourseYearLevelConflict";
			}
			else
			{
				int currentRegistrationQuantity = student.getRegistration().size();
				int studentRegistrationLimit = student.getAttendanceRole().getMaximumCourses();
				
				if (currentRegistrationQuantity >= studentRegistrationLimit)
				{
					return "registerCourseLimitReached";
				}
				else
				{
					new Registration(student, defaultGrade, course);
					course.setEnrollmentCount(1);
					return "registerCourseSuccess";
				}
			}
		}
	}
	
	/***********************************************************************/

	public static ArrayList<String> viewRegisteredCourses(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listofRegisteredCourses = new ArrayList<String>();
		listofRegisteredCourses.add(clientInfoArray[0]);
		listofRegisteredCourses.add(clientInfoArray[1]);
		listofRegisteredCourses.add(clientInfoArray[2]);
		
		String coursesubject, coursenumber, coursecode, course;
		
		for(int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						int numberOfRegisteredCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().size();
						
						for(int m=0; m<numberOfRegisteredCourses; m++)
						{
							coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getCourseSubject();
							coursenumber = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getCourseNumber());
							coursecode = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getCourseCode();
							course = coursecode +" "+ coursenumber + " - " + coursesubject;
							listofRegisteredCourses.add(course);
						}
					}
				}
			}
		}
		return listofRegisteredCourses;
	}
	
	/***********************************************************************/

	public static String dropCourse(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		for(int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						int numberOfRegisteredCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().size();
						
						for(int m=0; m<numberOfRegisteredCourses; m++)
						{
							if(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getCourseSubject().equals(clientInfoArray[3]))
							{
								int noOfRegistration = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getRegistrationList().size();
								
								for(int n=0; n<noOfRegistration; n++)
								{
									if(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getRegistrationList().get(n).getStudent().getMemberID()).equals(clientInfoArray[2]))
									{
										listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getRegistrationList().remove(n);
										listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().remove(m);
										return "dropCourseSuccess";
									}
								}
							}
						}
					}
				}
			}
		}
		
		return "dropCourseFailure";
	}
	
	/***********************************************************************/
	
	public static ArrayList<String> viewTimeTable(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listofschedules = new ArrayList<String>();
		listofschedules.add(clientInfoArray[0]);
		listofschedules.add(clientInfoArray[1]);
		listofschedules.add(clientInfoArray[2]);
		
		String coursesubject, weekday, starttime, startmeridiem, endtime, endmeridiem, schedule;
		
		for(int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						int numberOfRegisteredCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().size();
						
						for(int m=0; m<numberOfRegisteredCourses; m++)
						{
							int noOfCourseSchedules = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().size();
							
							for(int n=0; n<noOfCourseSchedules; n++)
							{
								coursesubject = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getCourse();
								weekday = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getWeekday();
								starttime = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getStartTime();
								startmeridiem = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getStartMeridiem();
								endtime = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getEndTime();
								endmeridiem = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).getCourse().getSchedule().get(n).getEndMeridiem();
								schedule = coursesubject +": "+ weekday + " - ["+ starttime +""+ startmeridiem +" - "+ endtime +""+ endmeridiem +"]";
								listofschedules.add(schedule);
							}
						}
					}
				}
			}
		}
		
		return listofschedules;
	}
	
	/***********************************************************************/
	
	public static ArrayList<String> viewGrades(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listofRegisteredCourses = new ArrayList<String>();
		listofRegisteredCourses.add(clientInfoArray[0]);
		listofRegisteredCourses.add(clientInfoArray[1]);
		listofRegisteredCourses.add(clientInfoArray[2]);
		
		for(int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
				
				for(int k=0; k<numberOfDepartmentStudents; k++)
				{
					if(clientInfoArray[2].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
					{
						int numberOfRegisteredCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().size();
						
						for(int m=0; m<numberOfRegisteredCourses; m++)
						{
							listofRegisteredCourses.add(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getRegistration().get(m).toString());
						}
					}
				}
			}
		}
		return listofRegisteredCourses;
	}
}
