package serverAppSide;
import server.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ServerConsole implements ServerIF
{
	private static final int DEFAULT_PORT = 5555;
	private static URSServer server;
	
	public ServerConsole (int port)
	{
		try
		{
			server= new URSServer(port,this);
			server.listen();
		}
		catch(IOException e)
		{
			
		}
	}
	
	public static void dispatchClientMessage(String[] clientInfoArray, ConnectionToClient client) throws IOException
	{
		try
		{
			if(clientInfoArray[0].equals("Login"))
			{
				ArrayList<String> message = Member.login(clientInfoArray[1],clientInfoArray[2]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("createDepartment"))
			{
				String message = StaffMember.createDepartment(clientInfoArray[1],clientInfoArray[2],clientInfoArray[3]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("createCourse"))
			{
				String message = StaffMember.createCourse(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("removeCourse"))
			{
				String message = StaffMember.removeCourse(clientInfoArray[2]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("createFaculty") || clientInfoArray[0].equals("createStaff"))
			{
				String message = StaffMember.registerEmployee(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("createStudent"))
			{
				String message = StaffMember.registerStudent(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("removeMember"))
			{
				String message = StaffMember.removeMember(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("registerCourse"))
			{
				String message = StudentMember.registerCourse(clientInfoArray[1],clientInfoArray[2]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("dropCourse"))
			{
				String message = StudentMember.dropCourse(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("assignInstructor"))
			{
				String message = StaffMember.assignInstructorToCourse(clientInfoArray[2], clientInfoArray[3]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("assignChair"))
			{
				String message = StaffMember.assignDepartmentChair(clientInfoArray[2], clientInfoArray[3]);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("postGrades"))
			{
				String message = Instructor.postGrades(clientInfoArray);
				client.sendToClient(message);
			}
			if(clientInfoArray[0].equals("getFaculties"))
			{
				client.sendToClient(University.getFacultyNames(clientInfoArray));
			}
			if(clientInfoArray[0].equals("getSchedules"))
			{
				client.sendToClient(Member.viewCourseSchedules(clientInfoArray));
			}
			if(clientInfoArray[0].equals("editDepartmentInfo"))
			{
				client.sendToClient(Chair.editDepartmentInfo(clientInfoArray));
			}
			if(clientInfoArray[0].equals("editUserProfile"))
			{
				client.sendToClient(Member.editUserProfile(clientInfoArray));
			}
			if(clientInfoArray[0].equals("getTimeTable"))
			{
				if(StudentMember.viewTimeTable(clientInfoArray).size() <= 3)
				{
					client.sendToClient("You're not registered in any course.");
				}
				else
				{
					client.sendToClient(StudentMember.viewTimeTable(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("viewCourseGrades"))
			{
				if(Instructor.viewCourseGrades(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No Grades Entered Yet!");
				}
				else
				{
					client.sendToClient(Instructor.viewCourseGrades(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getFacultyDepartments"))
			{
				if(University.getFacultyDepartments(clientInfoArray).size() <= 2)
				{
					client.sendToClient("Unable to find departments for the selected faculty");
				}
				else
				{
					client.sendToClient(University.getFacultyDepartments(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getDepartmentCourses"))
			{
				if(University.getSpecificDepartmentCourses(clientInfoArray).size() <= 3)
				{
					client.sendToClient("Unable to find courses for the selected department.");
				}
				else
				{
					client.sendToClient(University.getSpecificDepartmentCourses(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("viewDepartmentStudents"))
			{
				if(Chair.viewDepartmentStudents(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No students in your department at the moment.");
				}
				else
				{
					client.sendToClient(Chair.viewDepartmentStudents(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("viewRegisteredCourses"))
			{
				if(StudentMember.viewRegisteredCourses(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No Registered Courses Found.");
				}
				else
				{
					client.sendToClient(StudentMember.viewRegisteredCourses(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("viewGrades"))
			{
				if(StudentMember.viewGrades(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No Registered Courses Found.");
				}
				else
				{
					client.sendToClient(StudentMember.viewGrades(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getAllDepartments"))
			{
				if(University.getDepartments(clientInfoArray).size() <= 2)
				{
					client.sendToClient("No Departments available");
				}
				else
				{
					client.sendToClient(University.getDepartments(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getSpecificDepartmentInfo"))
			{
				if(University.getSpecificDepartmentInfo(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No Departments available");
				}
				else
				{
					client.sendToClient(University.getSpecificDepartmentInfo(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getAllCourses"))
			{
				if(University.getAllCourses(clientInfoArray).size() <= 2)
				{
					client.sendToClient("No Courses available");
				}
				else
				{
					client.sendToClient(University.getAllCourses(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("getCourseInfo"))
			{
				if(University.getCourseInfo(clientInfoArray).size() <= 2)
				{
					client.sendToClient("Unable to get course information");
				}
				else
				{
					client.sendToClient(University.getCourseInfo(clientInfoArray));
				}
			}
			if(clientInfoArray[0].equals("searchCourse"))
			{
				if(Member.searchCourses(clientInfoArray).size() <= 2)
				{
					client.sendToClient("Unable to find courses for the specified "+ clientInfoArray[2] +".");
				}
				else
				{	
					client.sendToClient(Member.searchCourses(clientInfoArray));
				}
			}
			if((clientInfoArray[0].equals("searchStudent")||clientInfoArray[0].equals("searchFacultyMember")||clientInfoArray[0].equals("searchStaff")))
	     	{
				if(StaffMember.searchMembers(clientInfoArray).size() <= 2)
				{
					client.sendToClient("Unable to find members for the specified "+ clientInfoArray[2] +".");
				}
				else
				{
					client.sendToClient(StaffMember.searchMembers(clientInfoArray));
				}
	     	}
			if(clientInfoArray[0].equals("viewUserProfile"))
	     	{
				if(Member.viewUserProfile(clientInfoArray).size() <= 2)
				{
					client.sendToClient("Something went wrong, Unable to find your information!");
				}
				else
				{
					client.sendToClient(Member.viewUserProfile(clientInfoArray));
				}
	     	}
			if(clientInfoArray[0].equals("getfacultyMembersforInstructor") || clientInfoArray[0].equals("getfacultyMembersforChair"))
	     	{
				if(StaffMember.viewFacultyMembers(clientInfoArray).size() <= 3)
				{
					client.sendToClient("Something went wrong, Unable to find your information!");
				}
				else
				{
					client.sendToClient(StaffMember.viewFacultyMembers(clientInfoArray));
				}
	     	}
			if(clientInfoArray[0].equals("getEnrolledStudents"))
	     	{
				if(EmployeeMember.viewCourseEnrolledStudents(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No students are enrolled in this course!");
				}
				else
				{
					client.sendToClient(EmployeeMember.viewCourseEnrolledStudents(clientInfoArray));
				}
	     	}
			if(clientInfoArray[0].equals("viewAssignedCourses"))
	     	{
				if(EmployeeMember.viewAssignedCourses(clientInfoArray).size() <= 3)
				{
					client.sendToClient("No courses assigned to this instructor!");
				}
				else
				{
					client.sendToClient(EmployeeMember.viewAssignedCourses(clientInfoArray));
				}
	     	}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	 public void accept() 
	 {
		 try
		 {
		      BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
		      String message;
		      
		      while (true) 
		      {
			        message = fromConsole.readLine();
			        server.handleMessageFromServerUI(message);
			        
			        if(message.startsWith("#wait"))
					{  
						  Long x = new Long(Integer.parseInt(message.substring(6)));
						  
						  server.stopListening();
						  
						  Thread.sleep(x*1000);
						  //try{TimeUnit.SECONDS.sleep(x);}
				          //catch(Exception e){display("#wait failed");}
						 
						  server.listen();
					}
				        	
				  	if(message.compareTo("#start")==0)
				  	{
				  		if(server.isListening()) 
				  			throw (new IOException());
				  		else server.listen();
				  	}
				  
				  	if(message.compareTo("#stop")==0)
					  server.stoppedlistening();
				
				  	if(message.compareTo("#quit")==0)
					  server.quit();
				  
				  	if(message.compareTo("#close")==0)
					  server.close();
				  
				  	if (message.compareTo("#number")==0)
				  		System.out.println(server.number());

					if(message.compareTo("#start")==0)
					{
				  		if(server.isListening())
				  			System.out.println("NOT ALLOWED, SERVER ALREADY STARTED");
				  		else
				  		{	
				  			server.listen();
				  			System.out.println("The server is started.");
				  		}
		  			}
					  	
		  			if(message.compareTo("#getPort")==0)
		  				System.out.println("Server's Port : "+ server.getPort());
		  		
		  			if(message.startsWith("#disconnect"))
		  			{
	  					for( Thread connections: server.getClientConnections())
	  					{
	  						System.out.println(message.substring(12));
	  						if(((ConnectionToClient) connections).getInfo("ID").equals(message.substring(12)));
	  							((ConnectionToClient) connections).close();
	  							display("Client" + (message.substring(12))+ " a ete disconnect.");
	  							break;
	  					}	
		  			}
				  
					if(message.equals("#allUsers"))
					{
						 Thread[] Users = server.getClientConnections();
					     for(int i=0;i<Users.length;i++)
					     {
					    	 ConnectionToClient co = (ConnectionToClient)Users[i];
					    	 this.display(co.getInfo("ID")+"");
					     }
					}
						  
					if(message.startsWith("#setPort"))
					{	
						if(server.isListening()==true)
						{	
							System.out.println("Error seting port");
						}
						else
						{
							server.setPort(Integer.parseInt(message.substring(9)));
						}
					}
		      	}
 			}
		 	catch (Exception ex) 
		 	{
		 		System.out.println("Unexpected error while reading from server console!");
		 	}
	 	}
		public void display(String message) 
		{
			System.out.println("SERVER MSG >"+ message);
		}
		
		public static void main(String[] args) 
		{
			ServerUI.display();
		}
}
	//End of ConsoleChat class