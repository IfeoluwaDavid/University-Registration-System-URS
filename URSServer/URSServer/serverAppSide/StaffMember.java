package serverAppSide;
import serverAppSide.Department;
import java.util.*;

public class StaffMember extends EmployeeMember
{
	private String qualification;
   
	public StaffMember(String firstName, String lastName, int memberID, String email, String dateofbirth, int sinNumber, String address, String password, String status, String position, int earning, String qualification) 
	{
		super(firstName, lastName, memberID, email, dateofbirth, sinNumber, address, password, status, position, earning);
		this.setQualification(qualification);
		University.getStaff().add(this);
	}
	
	
/*******************************************************************************************************************************/
	public String getQualification()
	{
		return qualification;
	}

	public void setQualification(String qualification)
	{
			this.qualification = qualification;
	}
	
/*******************************************************************************************************************************/
	
	public static String registerStudent(String memberInfoArray[])
	{
		ArrayList<String> memberInfoList = new ArrayList<String>(Arrays.asList(memberInfoArray));
		
		String firstName = memberInfoList.get(1);
		String lastName = memberInfoList.get(2); 
		String email = memberInfoList.get(3);
		String address = memberInfoList.get(4);
		String password = "password";
		String dateofbirth = "["+memberInfoList.get(5) + "-" + memberInfoList.get(6) + "-" + memberInfoList.get(7)+"]";
		int sinNumber = Integer.parseInt(memberInfoList.get(8));
		String status = memberInfoList.get(9);
		String department = memberInfoList.get(10);
		int yearlevel = Integer.parseInt(memberInfoList.get(11));
		int memberID = Integer.parseInt(memberInfoList.get(12));
		
		if(University.getSpecificDepartment(department) == null)
		{
			return "createStudentFailure";
		}
		else
		{
			Department studentdepartment = University.getSpecificDepartment(department);
			if(!studentdepartment.equals(null))
			{
				StudentMember newStudent = new StudentMember(firstName,lastName,memberID,email,
						dateofbirth,sinNumber,address,password,studentdepartment,yearlevel);

				if(status.equals("Part-Time"))
				{
					PartTime attendancerole = new PartTime(newStudent);
					newStudent.setAttendanceRole(attendancerole);
					return "createStudentSuccess";
				}
				else if(status.equals("Full-Time"))
				{
					FullTime attendancerole = new FullTime(newStudent);
					newStudent.setAttendanceRole(attendancerole);
					return "createStudentSuccess";
				}
				else
				{
					return "createStudentFailure";
				}
			}
			else
			{
				return "createStudentFailure";
			}
		}
	}

/*******************************************************************************************************************************/	
	
	public static String registerEmployee(String memberInfo[])
	{
		String firstName = memberInfo[1];
		String lastName = memberInfo[2]; 
		String email = memberInfo[3];
		String address = memberInfo[4];
		String password = "password";
		String dateofbirth = "["+memberInfo[5] + "-" + memberInfo[6] + "-" + memberInfo[7]+"]";
		int sinNumber = Integer.parseInt(memberInfo[8]);
		String status = memberInfo[9];
		String position = memberInfo[10];
		int earning = Integer.parseInt(memberInfo[11]);
		int memberID = Integer.parseInt(memberInfo[12]);
		
		if (memberInfo[0].equals("createFaculty"))
		{
			Faculty faculty = University.getSpecificFaculty(memberInfo[13]);
			
			if(!faculty.equals(null))
			{
				new FacultyMember(firstName, lastName, memberID, email, dateofbirth, sinNumber, address, password, status, position, earning, faculty);
				//System.out.println(nunu.toString());
				return "createFacultySuccess";
			}
			else
			{
				return "createFacultyFailure";
			}
		}
		else if (memberInfo[0].equals("createStaff"))
		{
			String qualification = memberInfo[13];
			StaffMember newstaff = new StaffMember(firstName,lastName,memberID,email,dateofbirth,sinNumber,status,address,password,position,earning,qualification);
			System.out.println(newstaff.toString());
			return "createStaffSuccess";
		}
		else
		{
			return "createStaffFailure";
		}
	}
	
/*******************************************************************************************************************************/

	public static String createDepartment(String departmentName, String duration, String facultyName)
	{
		int departmentDuration = Integer.parseInt(duration);
		Faculty departmentFaculty = University.getSpecificFaculty(facultyName);
		
		if(!departmentFaculty.equals(null))
		{
			new Department(departmentName, departmentDuration, departmentFaculty);
			return "createDepartmentSuccess";
		}
		else
		{
			return "createDepartmentFailure";
		}
	}

/*******************************************************************************************************************************/
	
	public static String createCourse(String[] courseInfoArray)
	{
		ArrayList<String> courseInfoArrayList = new ArrayList<String>(Arrays.asList(courseInfoArray));
		
		String courseSubject = courseInfoArrayList.get(1);
 		String courseCode = courseInfoArrayList.get(2); 
 		int courseNumber = Integer.parseInt(courseInfoArrayList.get(3));
 		String courseDepartmentName = courseInfoArrayList.get(4);
 		String courseSemester = courseInfoArrayList.get(5);
		int courseYearlevel  = Integer.parseInt(courseInfoArrayList.get(6));
		int courseCapacity = Integer.parseInt(courseInfoArrayList.get(7));
		String courseDescription = courseInfoArrayList.get(8);
		
		System.out.println(courseInfoArrayList);
		courseInfoArrayList.subList(0, 9).clear();
		List<Schedule> courseSchedules = Schedule.convertStringToSchedule(courseInfoArrayList, courseSubject);
		
		//System.out.println(courseSchedules);
		
		String section;
		if(courseSemester.equals("Fall"))
		{
			section = "FA";
		}
		else if(courseSemester.equals("Winter"))
		{
			section = "WA";
		}
		else
		{
			section = "TBA";
		}
		
		if(University.getSpecificDepartment(courseDepartmentName) == null)
		{
			return "createCourseFailure";
		}
		else
		{
			Department courseDepartment = University.getSpecificDepartment(courseDepartmentName);
			
			new Course(courseSubject, courseCode, courseNumber, courseSemester, section, courseCapacity, 
					courseDepartment, courseSchedules, courseYearlevel, courseDescription);
			
			return "createCourseSuccess";
		}
	}

/*******************************************************************************************************************************/
	
	public static String removeCourse(String course)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				int numberOfDepartmentCourses = listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size();
				
				for(int k=0; k<numberOfDepartmentCourses; k++)
				{
					if(listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).getCourseSubject().equals(course))
					{
						listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().remove(k);
						return "removeCourseSuccess";
					}
				}
			}
		}
		return "removeCourseFailure";
	}

/*******************************************************************************************************************************/	
	
	public void editCourse()
	{
		
	}

/*******************************************************************************************************************************/
	
	public static ArrayList<String> searchMembers(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfMatches = new ArrayList<String>();
		listOfMatches.add(clientInfoArray[0]);
		listOfMatches.add(clientInfoArray[1]);

		String firstname, lastname, memberID, member;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			if(clientInfoArray[0].equals("searchStudent"))
			{
				int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
				
				for(int j=0; j<numberOfFacultyDepartments; j++)
				{
					int numberOfDepartmentStudents = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().size();
					
					for(int k=0; k<numberOfDepartmentStudents; k++)
					{
						if(clientInfoArray[2].equals("ID"))
						{
							if(clientInfoArray[3].equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID())))
							{
								firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
								lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
								memberID = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID());
								member = firstname +" "+ lastname + " - " + memberID;
								listOfMatches.add(member);
							}
						}
						else if(clientInfoArray[2].equals("Department"))
						{
							if(clientInfoArray[3].toUpperCase().equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getDepartment().toUpperCase()))
							{
								firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
								lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
								memberID = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID());
								member = firstname +" "+ lastname + " - " + memberID;
								listOfMatches.add(member);
							}
						}
						else if(clientInfoArray[2].equals("Year Level"))
						{
							if(clientInfoArray[3].toUpperCase().equals(String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getYearLevel()).toUpperCase()))
							{
								firstname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
								lastname = listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
								memberID = String.valueOf(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID());
								member = firstname +" "+ lastname + " - " + memberID;
								listOfMatches.add(member);
							}
						}
						else
						{
							//Do nothing
						}
					}
				}
			}
			else if(clientInfoArray[0].equals("searchFacultyMember"))
			{
				int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
				
				for(int k=0; k<numberOfFacultyMembers; k++)
				{
					if(clientInfoArray[2].equals("ID"))
					{
						if(clientInfoArray[3].equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())))
						{
							firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
							lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
							memberID = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
							member = firstname +" "+ lastname + " - " + memberID;
							listOfMatches.add(member);
						}
					}
					else if(clientInfoArray[2].equals("Faculty Roles"))
					{
						int numberOfFacultyRoles = listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().size();
						
						for(int m=0; m<numberOfFacultyRoles; m++)
						{
							if(clientInfoArray[3].toUpperCase().equals("CHAIR"))
							{
								for(int p=0; p<numberOfFacultyRoles; p++)
								{
									if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(p) instanceof Chair)
									{
										firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
										lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
										memberID = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
										member = firstname +" "+ lastname + " - " + memberID;
										listOfMatches.add(member);
									}
								}
							}
							else if(clientInfoArray[3].toUpperCase().equals("INSTRUCTOR"))
							{
								for(int q=0; q<numberOfFacultyRoles; q++)
								{
									if(listOfFaculties.get(i).getFacultyMembers().get(k).getFacultyRoles().get(q) instanceof Instructor)
									{
										firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
										lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
										memberID = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
										member = firstname +" "+ lastname + " - " + memberID;
										listOfMatches.add(member);
									}
								}
							}
							else
							{
								
							}
						}
					}
					else if(clientInfoArray[2].equals("Faculty"))
					{
						if(clientInfoArray[3].equals(String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getFaculty().getFacultyName())))
						{
							firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
							lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
							memberID = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
							member = firstname +" "+ lastname + " - " + memberID;
							listOfMatches.add(member);
						}
					}
					else
					{
						//Do nothing
					}
				}
			}
		}
		if(clientInfoArray[0].equals("searchStaff"))
		{
			List<StaffMember> listOfStaff = University.getStaff();
			
			for(int k=0; k<listOfStaff.size(); k++)
			{
				if(clientInfoArray[2].equals("ID"))
				{
					if(clientInfoArray[3].equals(String.valueOf(listOfStaff.get(k).getMemberID())))
					{
						firstname = listOfStaff.get(k).getfirstName();
						lastname = listOfStaff.get(k).getlastName();
						memberID = String.valueOf(listOfStaff.get(k).getMemberID());
						member = firstname +" "+ lastname + " - " + memberID;
						listOfMatches.add(member);
					}
				}
				else if(clientInfoArray[2].equals("Email"))
				{
					if(clientInfoArray[3].equals(listOfStaff.get(k).getEmail()))
					{
						firstname = listOfStaff.get(k).getfirstName();
						lastname = listOfStaff.get(k).getlastName();
						memberID = String.valueOf(listOfStaff.get(k).getMemberID());
						member = firstname +" "+ lastname + " - " + memberID;
						listOfMatches.add(member);
					}
				}
				else
				{
					
				}
			}
		}
		return listOfMatches;
	}

/*******************************************************************************************************************************/	

	public static String removeMember(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfMatches = new ArrayList<String>();
		listOfMatches.add(clientInfoArray[0]);
		listOfMatches.add(clientInfoArray[1]);
		
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
						listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentStudents().remove(k);
						return "removeMemberSuccess";
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
					listOfFaculties.get(i).getFacultyMembers().remove(k);
					return "removeMemberSuccess";
				}
				
			}
		}
		
		List<StaffMember> listOfStaff = University.getStaff();
		
		for(int k=0; k<listOfStaff.size(); k++)
		{
			if(clientInfoArray[2].equals(String.valueOf(listOfStaff.get(k).getMemberID())))
			{
				listOfStaff.remove(k);
				return "removeMemberSuccess";
			}
		}
		return "removeMemberFailure";
	}
	
/*******************************************************************************************************************************/	
	
	public static String assignInstructorToCourse(String memberID, String selectedCourse)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		Course course = null;
		FacultyMember facultymember = null;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
			
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				if(Integer.parseInt(memberID) == listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())
				{
					facultymember = listOfFaculties.get(i).getFacultyMembers().get(k);
				}
			}
		}
		
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
		
		if(!course.equals(null) && !facultymember.equals(null))
		{
			Instructor instructor = new Instructor(facultymember);
			course.setInstructor(instructor);
			instructor.getFacultyMember().getAssignedCourses().add(course);
			return "assignInstructorSuccess";
		}
		else
		{
			return "assignInstructorFailure";
		}
	}

/*******************************************************************************************************************************/
	
	public static String assignDepartmentChair(String memberID, String selectedDepartment)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		Department department = null;
		FacultyMember facultymember = null;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
			
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				if(Integer.parseInt(memberID) == listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID())
				{
					facultymember = listOfFaculties.get(i).getFacultyMembers().get(k);
				}
			}
		}
		
		for (int i = 0; i < listOfFaculties.size(); i++)
		{	
			int numberOfFacultyDepartments = listOfFaculties.get(i).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(selectedDepartment.equals(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName()))
				{
					department = listOfFaculties.get(i).getFacultyDepartments().get(j);
				}
			}
		}
		
		if (!facultymember.equals(null) && !department.equals(null))
		{
			Chair chair = new Chair(facultymember);
			department.setChair(chair);
			facultymember.setDepartment(department);
			return "assignChairSuccess";
		}
		else
		{
			return "assignChairFailure";
		}
	}

/*******************************************************************************************************************************/
	
	public void resolveTimeConflict()
	{
		
	}

/*******************************************************************************************************************************/
	
	public static ArrayList<String> viewFacultyMembers(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listofAllFacultyMembers = new ArrayList<String>();
		listofAllFacultyMembers.add(clientInfoArray[0]);
		listofAllFacultyMembers.add(clientInfoArray[1]);
		listofAllFacultyMembers.add(clientInfoArray[2]);
		
		String firstname, lastname, memberid, facultymember;
		
		for (int i = 0; i < listOfFaculties.size(); i++) 
		{	
			int numberOfFacultyMembers = listOfFaculties.get(i).getFacultyMembers().size();
			
			for(int k=0; k<numberOfFacultyMembers; k++)
			{
				firstname = listOfFaculties.get(i).getFacultyMembers().get(k).getfirstName();
				lastname = listOfFaculties.get(i).getFacultyMembers().get(k).getlastName();
				memberid = String.valueOf(listOfFaculties.get(i).getFacultyMembers().get(k).getMemberID());
				facultymember = firstname +" "+ lastname + " - " + memberid;
				listofAllFacultyMembers.add(facultymember);
			}
		}
		return listofAllFacultyMembers;
	}
	
/*******************************************************************************************************************************/
	
	public String toString()
	{
		String employeeMemberInfo = super.toString();
     	return employeeMemberInfo + ", " + qualification;
	}
	
/*******************************************************************************************************************************/
}