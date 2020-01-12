package serverAppSide;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerFileIO 
{
	public static Boolean writeToFile(String filename, Object object)
	{
		try 
		{
			FileWriter filewriter = new FileWriter(filename, true);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			PrintWriter writeToFile = new PrintWriter(bufferedwriter);
		    writeToFile.println(object);
		    writeToFile.close();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	/*public static void readFromFile()
	{
		
	}*/
	public static void backUpObjects()
	{
		ArrayList<Faculty> listOfFaculties = University.getFaculties();
		
		for(int i = 0; i < listOfFaculties.size(); i++) 
		{
			writeToFile("List Of Faculties.txt", listOfFaculties.get(i).getFacultyName());
			for(int j = 0; j < listOfFaculties.get(i).getFacultyDepartments().size(); j++)
			{
				writeToFile(listOfFaculties.get(i).getFacultyName()+" Departments.txt", listOfFaculties.get(i).getFacultyDepartments().get(j).toString());
				for(int k = 0; k < listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().size(); k++)
				{
					writeToFile(listOfFaculties.get(i).getFacultyDepartments().get(j).getDepartmentName()+" Courses.txt", listOfFaculties.get(i).getFacultyDepartments().get(j).getCourses().get(k).toString());
				}
			}
		}
	}
	
	public static Boolean fetchDepartment (String filename, String attribute)
	{
	      Scanner x = null;
	      try
	      {
	         x = new Scanner(new File(filename));
	         for(int i = 0; i < 6; i++)
	         {
	            String[] objectAttributes = x.nextLine().split(", ");
	            
	            if (objectAttributes[0].equals(attribute))
	            {
	            	x.close();
	            	return true;
	            }
	            
	         }
	         x.close();
	         return false;
	     } 
	     catch(FileNotFoundException e)
	     {
	        System.out.println("Cannot find file " + e.getMessage());
	        return false;
	     }
	     
	}
	
	/*
	 
	 		//Boolean writeDepartmentToFile = ServerFileIO.writeToFile("ListOfAllDepartments.txt", newdepartment.toString());
		//Boolean writeCoursesToFile = ServerFileIO.writeToFile(newdepartment.getDepartmentName()+"Courses.txt", newdepartment.getCourses().toString());
		//Boolean writeStudentsToFile = ServerFileIO.writeToFile(newdepartment.getDepartmentName()+"Students.txt", newdepartment.getDepartmentStudents().toString());
		 
*/

	
}
