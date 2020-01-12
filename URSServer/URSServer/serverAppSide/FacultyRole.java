package serverAppSide;

public class FacultyRole
{
	private FacultyMember facultyMember;

	public FacultyRole(FacultyMember facultyMember)
	{
	  this.facultyMember = facultyMember;
	}

	public FacultyMember getFacultyMember()
	{
		return facultyMember;
	}

	public void setFacultyMember(FacultyMember facultyMember)
	{
		this.facultyMember = facultyMember;
	}
	
	public String toString()
	{
		return facultyMember.toString();
	}
}
