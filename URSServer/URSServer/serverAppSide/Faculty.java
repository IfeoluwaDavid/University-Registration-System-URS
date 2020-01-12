package serverAppSide;

import java.util.*;

public class Faculty
{
	private String facultyName;
	private ArrayList<Department> facultyDepartments;
	private ArrayList<FacultyMember> facultyMembers;
	
	public Faculty(String facultyName)
	{
		this.facultyName = facultyName;
		this.facultyDepartments = new ArrayList<Department>();
		this.setFacultyMembers(new ArrayList<FacultyMember>());
	}
	
	public String getFacultyName()
	{
		return facultyName;
	}

	public void setFacultyName(String facultyName)
	{
		this.facultyName = facultyName;
	}

	public ArrayList<Department> getFacultyDepartments()
	{
		return facultyDepartments;
	}

	public void setDepartments(ArrayList<Department> departments)
	{
		this.facultyDepartments = departments;
	}
	
	public ArrayList<FacultyMember> getFacultyMembers()
	{
		return facultyMembers;
	}

	public void setFacultyMembers(ArrayList<FacultyMember> facultyMembers)
	{
		this.facultyMembers = facultyMembers;
	}
	
	public String toString()
	{
		return facultyName + "	-	" + facultyDepartments;
	}
}
