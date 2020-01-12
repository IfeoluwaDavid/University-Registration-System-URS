package serverAppSide;

public abstract class AttendanceRole
{
	private StudentMember student;
	
	public AttendanceRole(StudentMember student)
	{
		this.setStudent(student);
	}

	public StudentMember getStudent()
	{
		return student;
	}

	public void setStudent(StudentMember student)
	{
		this.student = student;
	}

	public abstract int getMaximumCourses();
}
