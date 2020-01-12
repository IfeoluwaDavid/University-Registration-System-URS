package clientAppSide;
import javax.swing.*;
import client.*;
import java.util.*;
import java.io.*;

public class ClientConsole implements ChatIF 
{
    /*******************************************************************/

    static URSClient client;
    static ClientUserInfo user;

    public ClientConsole(String id ,String host, int port) 
    {
        try 
        {
        	client = new URSClient(id,host, port, this);
        	user = new ClientUserInfo();
        	SystemLaunchUI.display();
        } 
        catch(IOException exception) 
        {
            JOptionPane.showMessageDialog(null, "Cannot open connection.  Awaiting command.");
        }
    }
    
    public static void dispatchServerMessage(Object message) 
    {
    	if(message instanceof String)
    	{
    		String feedback = (String) message;
    		GUIMessageHandler.displayMessage(feedback);
    	}
        if(message instanceof ArrayList)
        {
        	@SuppressWarnings("unchecked")
			ArrayList<String> list = (ArrayList<String>) message;
        	if(list.get(0).equals("LoginSuccess") || list.get(0).equals("LoginFailure"))
    		{
    			LoginUI.createClientUserInfo(list);
    		}
        	if(list.get(0).equals("editProfileSuccess") || list.get(0).equals("editProfileFailure"))
    		{
    			updateClientUserInfo(list);
    		}
        	if(list.get(0).equals("editDepartmentSuccess") || list.get(0).equals("editDepartmentFailure"))
    		{
        		updateClientUserInfo(list);
    		}
        	else if(list.get(1).equals("publicUserBrowseFaculties"))
        	{
        		SystemLaunchUI.publicUserBrowseFaculties(list);
        	}
        	else if(list.get(1).equals("staffMenuDisplayFaculties"))
        	{
        		StaffMainMenuUI.staffMenuDisplayFaculties(list);
        	}
        	else if(list.get(1).equals("facultyMenuDisplayFaculties"))
        	{
        		FacultyMainMenuUI.facultyMenuDisplayFaculties(list);
        	}
        	else if(list.get(1).equals("studentMenuDisplayFaculties"))
         	{
        		StudentMainMenuUI.studentMenuDisplayFaculties(list);
         	}
        	else if(list.get(1).equals("facultyOptionsForRegisterFaculty"))
         	{
         		RegisterFacultyUI.facultyOptionsForRegisterFaculty(list);
         	}
        	else if(list.get(1).equals("createDepartmentFacultyOptions"))
         	{
         		CreateDepartmentUI.createDepartmentFacultyOptions(list);
         	}
        	else if(list.get(1).equals("staffMenuDisplayDepartments"))
         	{
        		StaffMainMenuUI.staffMenuDisplayDepartments(list);
         	}
        	else if(list.get(1).equals("publicUserBrowseDepartments"))
         	{
        		SystemLaunchUI.publicUserBrowseDepartments(list);
         	}
        	else if(list.get(1).equals("studentMenuDisplayDepartments"))
         	{
        		StudentMainMenuUI.studentMenuDisplayDepartments(list);
         	}
        	else if(list.get(1).equals("facultyMenuDisplayDepartments"))
        	{
        		FacultyMainMenuUI.facultyMenuDisplayDepartments(list);
        	}
        	else if(list.get(1).equals("displayUsersList"))
         	{
        		DisplayUsersListUI.displayUsersList(list);
         	}
        	else if(list.get(1).equals("displayDepartmentStudents"))
         	{
        		ViewDepartmentStudents.displayDepartmentStudents(list);
         	}
        	else if(list.get(1).equals("displayChairDepartmentInfo"))
         	{
        		MyDepartmentUI.displayDepartmentInfo(list);
         	}
        	else if(list.get(1).equals("facultyAssignedCourses"))
         	{
        		FacultyAssignedCoursesUI.displayObjectsList(list);
         	}
        	else if(list.get(1).equals("displayDepartmentInfo"))
         	{
        		ViewDepartmentInfoUI.displayDepartmentInfo(list);
         	}
        	else if(list.get(1).equals("displayObjectsList"))
         	{
        		DisplayObjectsListUI.displayObjectsList(list);
         	}
        	else if(list.get(1).equals("createCourseDepartmentOptions"))
         	{
        		CreateCourseUI.createCourseDepartmentOptions(list);
         	}
        	else if(list.get(1).equals("departmentOptionsForRegisterStudent"))
         	{
        		RegisterStudentUI.departmentOptionsForRegisterStudent(list);
         	}
        	else if(list.get(1).equals("displayAllCourses"))
         	{
        		SearchCourseUI.displayAllCourses(list);
         	}
        	else if(list.get(1).equals("displayCourseInfo"))
         	{
        		ViewCourseInfoUI.displayCourseInfo(list);
         	}
        	else if(list.get(1).equals("displaySearchMemberResults"))
         	{
        		SearchMemberUI.displaySearchMemberResults(list);
         	}
        	else if(list.get(1).equals("displaySchedulesList"))
         	{
        		ViewCourseSchedulesUI.displaySchedulesList(list);
         	}
        	else if(list.get(1).equals("studentUserViewProfile"))
         	{
        		ViewStudentProfileUI.displayInfo(list);
         	}
        	else if(list.get(1).equals("staffUserViewProfile"))
         	{
        		ViewStaffProfileUI.displayInfo(list);
         	}
        	else if(list.get(1).equals("facultyUserViewProfile"))
         	{
        		ViewFacultyProfileUI.displayInfo(list);
         	}
        	else if(list.get(1).equals("displayMemberProfile"))
         	{
        		SearchMemberUI.displayMemberProfile(list);
         	}
        	else if(list.get(1).equals("displayEnrolledStudents"))
         	{
        		FacultyPostGradesUI.displayEnrolledStudents(list);
         	}
        	else if(list.get(1).equals("displayCourseGrades"))
         	{
        		FacultyUpdateGradesUI.displayCourseGrades(list);
         	}
        	else if(list.get(1).equals("displayDepartmentStudents"))
         	{
        		FacultyUpdateGradesUI.displayCourseGrades(list);
         	}
        }
    }
    
    public static void updateClientUserInfo(ArrayList<String> feedback)
    {
    	if(feedback.get(0).equals("editProfileSuccess"))
    	{
			ClientUserInfo.user.setfirstName(feedback.get(1));
			ClientUserInfo.user.setlastName(feedback.get(2));
			ClientUserInfo.user.setEmail(feedback.get(3));
			
			JOptionPane.showMessageDialog(null, "Successfully Updated!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.get(0).equals("editProfileFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to save changes", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.get(0).equals("editDepartmentSuccess"))
    	{
    		ClientUserInfo.user.setDepartment(feedback.get(1));
    		JOptionPane.showMessageDialog(null, "Successfully Updated Department Info", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.get(0).equals("editDepartmentFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Update Department Info!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Something went wrong. Sorry!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    public void display(String message) 
    {
        System.out.println(message);
    }

    public void setclient(URSClient c)
    {
        client = c;
    }

    public static void accept(ArrayList<String> serverInfo) 
    {
    	if(serverInfo.isEmpty())
    	{
    		JOptionPane.showMessageDialog(null, "Empty Fields");
    	}
    	else
    	{
    		client.handleMessageFromClientUI(serverInfo);
    	}
    }
    
    public static void main(String[] args)
    {
    	ClientUI.display();
        //chat.accept();
    }
}
//End of ConsoleChat class
