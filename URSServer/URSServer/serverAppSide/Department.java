package serverAppSide;

import java.io.Serializable;
import java.util.*;

public class Department
{
	private String departmentName;
	public ArrayList<Course> departmentCourses;
	private int duration;
	private ArrayList<StudentMember> departmentStudents;
	private Faculty departmentFaculty;
	private Chair chair;
	
	/*public Department() 
	{
		this.departmentName = "";
		this.departmentCourses = new ArrayList<Course>();
		this.duration = 0;
		this.departmentStudents = new ArrayList<StudentMember>();
		this.departmentFaculty = null;
	}*/

	public Department(String departmentName, int duration, Faculty departmentFaculty) 
	{
		this.departmentName = departmentName;
		this.departmentCourses = new ArrayList<Course>();
		this.duration = duration;
		this.departmentStudents = new ArrayList<StudentMember>();
		this.departmentFaculty = departmentFaculty;
		this.setChair(null);
		departmentFaculty.getFacultyDepartments().add(this);
	}
	
	public String getDepartmentName()
	{
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
	
	public ArrayList<Course> getCourses()
	{
		return departmentCourses;
	}
	
	public void setCourses(ArrayList<Course> courses) 
	{
		this.departmentCourses = courses;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	public ArrayList<StudentMember> getDepartmentStudents()
	{
		return departmentStudents;
	}
	
	public void setDepartmentStudents(ArrayList<StudentMember> departmentStudents)
	{
		this.departmentStudents = departmentStudents;
	}
	
	public Faculty getFaculty()
	{
		return departmentFaculty;
	}
	
	public void setFaculty(Faculty faculty)
	{
		this.departmentFaculty = faculty;
	}
	
	public String toString()
	{
		return departmentName + ", " + duration + ", " + departmentFaculty.getFacultyName();
	}

	public Chair getChair()
	{
		return chair;
	}

	public void setChair(Chair chair)
	{
		this.chair = chair;
	}
}
