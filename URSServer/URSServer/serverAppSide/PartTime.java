package serverAppSide;

public class PartTime extends AttendanceRole
{
	public static int maximumCourses = 4;
	private int incomeSupportBenefits;
	
	public PartTime(StudentMember student)
	{
		super(student);
		this.incomeSupportBenefits = 0;
	}

	public int getIncomeSupport()
	{
		return incomeSupportBenefits;
	}

	public void setIncomeSupport(int incomeSupport)
	{
		this.incomeSupportBenefits = incomeSupport;
	}
	
	public void registrationLimit(int incomeSupport)
	{
		this.incomeSupportBenefits = incomeSupport;
	}
	
	@Override
	public int getMaximumCourses() 
	{
		return maximumCourses;
	}
}
