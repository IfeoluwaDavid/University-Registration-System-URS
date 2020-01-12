package serverAppSide;

import java.util.ArrayList;

public class Chair extends FacultyRole
{
	private String researchTitle; 

	public Chair(FacultyMember facultymember)
	{
	  super(facultymember);
	  this.researchTitle = "No Research Title";
	  facultymember.getFacultyRoles().add(this);
	}

	public String getResearchTitle()
	{
		return researchTitle;
	}

	public void setResearchTitle(String researchTitle)
	{
		this.researchTitle = researchTitle;
	}
	
	public String toString()
	{
		String facultyMemberInfo = super.toString();
		return facultyMemberInfo + " " + researchTitle;
	}
	
	public static ArrayList<String> viewDepartmentStudents(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> listOfDepartmentStudents = new ArrayList<String>();
		listOfDepartmentStudents.add(clientInfoArray[0]);
		listOfDepartmentStudents.add(clientInfoArray[1]);
		listOfDepartmentStudents.add(clientInfoArray[2]);
		
		String firstname, lastname, memberid, student;
		
		for( int p=0 ; p<listOfFaculties.size(); p++)
		{
			int numberOfFacultyDepartments = listOfFaculties.get(p).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(clientInfoArray[2].equals(listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentName()))
				{
					int numberOfDepartmentStudents = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().size();
					
					for(int k=0; k<numberOfDepartmentStudents; k++)
					{
						firstname = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getfirstName();
						lastname = listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getlastName();
						memberid = String.valueOf(listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentStudents().get(k).getMemberID());
						student = firstname + " " + lastname + " - " + memberid;
						listOfDepartmentStudents.add(student);
					}
				}
			}
		}
		
		return listOfDepartmentStudents;
	}
	
	public static ArrayList<String> editDepartmentInfo(String[] clientInfoArray)
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		ArrayList<String> newClientSideChairInfo = new ArrayList<String>();
		
		for( int p=0 ; p<listOfFaculties.size(); p++)
		{
			int numberOfFacultyDepartments = listOfFaculties.get(p).getFacultyDepartments().size();
			
			for(int j=0; j<numberOfFacultyDepartments; j++)
			{
				if(clientInfoArray[3].equals(listOfFaculties.get(p).getFacultyDepartments().get(j).getDepartmentName()))
				{
					String operationFeedback = "editDepartmentSuccess";
					listOfFaculties.get(p).getFacultyDepartments().get(j).setDepartmentName(clientInfoArray[1]);
					listOfFaculties.get(p).getFacultyDepartments().get(j).setDuration(Integer.parseInt(clientInfoArray[2]));
					
					newClientSideChairInfo.add(operationFeedback);
					newClientSideChairInfo.add(clientInfoArray[1]);
					return newClientSideChairInfo;
				}
			}
		}
		
		String operationFeedback = "editDepartmentFailure";
		newClientSideChairInfo.add(operationFeedback);
		return newClientSideChairInfo;
	}
}
