package serverAppSide;

public class Graduate extends LevelRole
{
	private String thesisTitle;
	
	public Graduate(StudentMember student, String thesisTitle)
	{
		super(student);
		this.setThesisTitle(thesisTitle);
	}

	public String getThesisTitle()
	{
		return thesisTitle;
	}

	public void setThesisTitle(String thesisTitle)
	{
		this.thesisTitle = thesisTitle;
	}

}
