package serverAppSide;

public class LevelRole 
{
	private StudentMember student;
	
	public LevelRole(StudentMember student)
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
}
