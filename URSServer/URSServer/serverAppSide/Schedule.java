package serverAppSide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule 
{
	private String course, weekday, startTime, endTime, startMeridiem, endMeridiem;
	
	/**********************************/
	
	public Schedule(String course, String weekday, String startTime, String startMeridiem, String endTime, String endMeridiem)
	{
			this.course = course;
			this.weekday = weekday;
			this.startTime = startTime;
			this.startMeridiem = endMeridiem;
			this.endTime = endTime;
			this.endMeridiem = endMeridiem;
	}

	public String getWeekday()
	{
		return weekday;
	}

	public void setWeekday(String weekday)
	{
		this.weekday = weekday;
	}

	public String getStartMeridiem()
	{
		return startMeridiem;
	}

	public void setStartMeridiem(String startMeridiem)
	{
		this.startMeridiem = startMeridiem;
	}

	public String getEndMeridiem()
	 {
		return endMeridiem;
	}

	public void setEndMeridiem(String endMeridiem)
	{
		this.endMeridiem = endMeridiem;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime) 
	{
		this.endTime = endTime;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}
	
	public String toString()
	{
		return course + " : "+ weekday + " - " + startTime + " " + startMeridiem + " " + endTime + " " + endMeridiem;
		
	}
	
	public static List<Schedule> convertStringToSchedule(ArrayList<String> courseInfoArrayList, String coursename)
	{
		List<Schedule> courseSchedules = new ArrayList<Schedule>();
        for(int i = 0; i<courseInfoArrayList.size(); i++)
		{
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(courseInfoArrayList.get(i).split(" ")));
			
			list.remove(3);
			
			for(int j = 0; j<list.size(); j++)
		    {
		        String item = list.get(j);
		        
		        StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(item);
                
		        if(item.substring(0, 1).equals("("))
		        {
            		stringbuilder.deleteCharAt(0);
            		list.set(j, stringbuilder.toString());
            		stringbuilder.setLength(0);
		        }
		        
		        if(item.substring(item.length() - 1).equals(")"))
		        {
		            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
		            list.set(j, stringbuilder.toString());
            		stringbuilder.setLength(0);
		        }
		        
		        /*char character = list.get(j).charAt(0);
		        if(Character.isDigit(character))
		        {
		            item = list.get(j).substring(0, list.get(j).length() - 3);
		            list.set(j, item);
		        }*/
		    }
			
			String weekday = list.get(0);
			String startTime = list.get(1);
			String startMeridiem = list.get(2);
			String endTime = list.get(3);
			String endMeridiem = list.get(4);
			
			Schedule scheduleObject = new Schedule(coursename, weekday, startTime, startMeridiem, endTime, endMeridiem);
			courseSchedules.add(scheduleObject);
		}
        
        return courseSchedules;
	}
}