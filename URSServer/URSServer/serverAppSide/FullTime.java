package serverAppSide;

public class FullTime extends AttendanceRole
{
	public static int maximumCourses = 6;
	private int taxCreditBenefits;
	
	public FullTime(StudentMember student)
	{
		super(student);
		this.taxCreditBenefits = 0;
	}

	public int getTaxCreditBenefits()
	{
		return taxCreditBenefits;
	}

	public void setTaxCreditBenefits(int taxCreditBenefits)
	{
		this.taxCreditBenefits = taxCreditBenefits;
	}

	@Override
	public int getMaximumCourses()
	{
		return maximumCourses;
	}
}