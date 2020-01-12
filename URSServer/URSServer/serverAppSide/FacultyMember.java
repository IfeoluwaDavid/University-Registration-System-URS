package serverAppSide;

import java.util.*;

public class FacultyMember extends EmployeeMember
{
	private Faculty faculty;
	private List<Course> assignedCourses;
	private List<FacultyRole> facultyRoles;
	private Department department;
	
	public FacultyMember(String firstName, String lastName, int memberID, String email, String dateofbirth, int sinNumber, 
						 String address, String password, String status, String Position, int earning, Faculty faculty)
	{
		super(firstName, lastName, memberID, email, dateofbirth, sinNumber, address, password, status, Position, earning);
		this.setFaculty(faculty);
		this.assignedCourses = new ArrayList<Course>();
		this.facultyRoles = new ArrayList<FacultyRole>();
		this.setDepartment(null);
		faculty.getFacultyMembers().add(this);
	}

	public List<Course> getAssignedCourses()
	{
		Set<Course> hashset = new HashSet<Course>();
		hashset.addAll(assignedCourses);
		assignedCourses.clear();
		assignedCourses.addAll(hashset);
		return assignedCourses;
	}

	public void setAssignedCourses(List<Course> assignedCourses)
	{
		this.assignedCourses = assignedCourses;
	}

	public List<FacultyRole> getFacultyRoles()
	{
		return facultyRoles;
	}

	public void setFacultyRoles(List<FacultyRole> facultyRoles)
	{
		this.facultyRoles = facultyRoles;
	}
	
	public String toString()
	{
		String employeeMemberInfo = super.toString();
		return employeeMemberInfo + ", " + faculty.getFacultyName() + ", " + facultyRoles;
	}

	public Faculty getFaculty()
	{
		return faculty;
	}

	public void setFaculty(Faculty faculty)
	{
		this.faculty = faculty;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}
}