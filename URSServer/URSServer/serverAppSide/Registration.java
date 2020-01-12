package serverAppSide;

public class Registration 
{
	private StudentMember student;
	private Course course;
	private String grade; 

	/**********************************/
	
	public Registration(StudentMember student, String grade, Course course) 
	{
		this.setStudent(student);
		this.setGrade("IP");
		this.setCourse(course);
		course.getRegistrationList().add(this);
		student.getRegistration().add(this);
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public StudentMember getStudent()
	{
		return student;
	}

	public void setStudent(StudentMember student)
	{
		this.student = student;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	public String toString()
	{
		return course.getCourseSubject() + " : " + student.getfirstName() + " " + student.getlastName() + " - " + student.getMemberID() + " - " + grade;
	}
}
