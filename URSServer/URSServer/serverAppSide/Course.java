package serverAppSide;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Course
{
	private String courseSubject;
	private String courseCode;
	private int courseNumber;
	private String semester;
	private String section;
	private int capacity;
	private int enrollmentCount;
	private Department department;
	private Instructor instructor;
	private List<Schedule> schedule;
	private int yearlevel;
	private ArrayList<Registration> registration;
	private String description;

	public Course(String courseSubject, String courseCode, int courseNumber, String semester, String section,
				  int capacity, Department department, List<Schedule> schedule, int yearlevel, String description)
	{
		this.courseSubject = courseSubject;
		this.courseCode = courseCode;
		this.courseNumber = courseNumber;
		this.semester = semester;
		this.setSection(section);
		this.capacity = capacity;
		this.enrollmentCount = 0;
		this.department = department;
		this.instructor = null;
		this.schedule = schedule;
		this.yearlevel = yearlevel;
		this.registration = new ArrayList<Registration>();
		this.description = description;
		department.getCourses().add(this);
	}
	
	/***********************/ 
	public String getCourseSubject()
	{
		return courseSubject;
	}

	public void setCourseSubject(String courseSubject)
	{
		this.courseSubject = courseSubject;
	}
	
	/***********************/
	
	public String getCourseCode()
	{
		return courseCode;
	}

	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	
	/***********************/
	
	public int getCourseNumber()
	{
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber)
	{
		this.courseNumber = courseNumber;
	}
	
	/***********************/
	
	public String getSemester()
	{
		return semester;
	}

	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	
	/***********************/
	
	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	/***********************/
	
	public int getEnrollmentCount()
	{
		return enrollmentCount;
	}

	public void setEnrollmentCount(int enrollmentCount) 
	{
		this.enrollmentCount = this.enrollmentCount + enrollmentCount;
	}
	
	/***********************/
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	/***********************/

	public ArrayList<Registration> getRegistrationList()
	{
		return registration;
	}
	
	public void setDepartment(Department newdepartment)
	{
	  this.department = newdepartment;
	}
	
	public String getDepartment() 
	{
	  return department.getDepartmentName();
	}

	public static Boolean createCourse(Course newcourse)
	{
		try 
		{
			FileWriter filewriter = new FileWriter("ListOfAvailableCourses.txt", true);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			PrintWriter writeToFile = new PrintWriter(bufferedwriter);
		    writeToFile.println(newcourse.toString());
		    writeToFile.close();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public Instructor getInstructor()
	{
		return instructor;
	}
	
	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}
	
	public int getYearlevel()
	{
		return yearlevel;
	}
	
	public void setYearlevel(int yearlevel)
	{
		this.yearlevel = yearlevel;
	}
	
	public List<Schedule> getSchedule()
	{
		return schedule;
	}
	
	public void setSchedule(List<Schedule> schedule)
	{
		this.schedule = schedule;
	}
	
	public String toString()
	{
		return  courseSubject + ", " + courseCode + ", " + courseNumber + ", " + 
				semester + ", " + section + ", " + capacity + ", " + enrollmentCount + ", " + department.getDepartmentName() + ", " + schedule + ", " + yearlevel + ", " + description + ". ";
	}

	public String getSection()
	{
		return section;
	}

	public void setSection(String section)
	{
		this.section = section;
	}
}