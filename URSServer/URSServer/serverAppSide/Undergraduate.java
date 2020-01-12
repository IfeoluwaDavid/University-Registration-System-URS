package serverAppSide;

public class Undergraduate extends LevelRole
{
	private String degreeProject;
	
	public Undergraduate(StudentMember student, String degreeProject)
	{
		super(student);
		this.setDegreeProject(degreeProject);
	}

	public String getDegreeProject() 
	{
		return degreeProject;
	}

	public void setDegreeProject(String degreeProject)
	{
		this.degreeProject = degreeProject;
	}
}
