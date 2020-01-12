package clientAppSide;

import javax.swing.JOptionPane;

public class GUIMessageHandler 
{
	public static void displayMessage(String feedback)
	{
		if(feedback.equals("createDepartmentSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Created Department!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("createDepartmentFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Create Department!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("createCourseSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Created Course!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("createCourseFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Create Course!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("removeCourseSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Removed Course!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("removeCourseFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Remove Course!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("createStudentSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Created Student!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("createStudentFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Create Student!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("createFacultySuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Created Faculty Member!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("createFacultyFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Create Faculty Member!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("createStaffSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Created Staff Member!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("createStaffFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to Create Staff Member!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("assignInstructorSuccess"))
    	{
    		JOptionPane.showMessageDialog(null, "Successfully Assigned Instructor!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.equals("assignInstructorDuplicate"))
    	{
    		JOptionPane.showMessageDialog(null, "This Instructor is already assigned to this Course!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.equals("assignInstructorFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Sorry, Unable to Assign Instructor!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("assignChairSuccess"))
    	{
    		JOptionPane.showMessageDialog(null, "Successfully Assigned Chair!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.equals("assignChairFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Sorry, Unable to Assign Chair!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("removeMemberSuccess"))
		{
			JOptionPane.showMessageDialog(null, "Succesfully Removed Member!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("removeMemberFailure"))
		{
			JOptionPane.showMessageDialog(null, feedback, "Unable to remove member!", JOptionPane.ERROR_MESSAGE);
		}
    	else if(feedback.equals("registerCourseDuplicate"))
    	{
    		JOptionPane.showMessageDialog(null, "Duplicate Registration is not Allowed", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("registerCourseNotFound"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to find the selected course", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("registerCourseYearLevelConflict"))
    	{
    		JOptionPane.showMessageDialog(null, "Year Level Ineligibility!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if (feedback.equals("registerCourseFilledUp"))
    	{
    		JOptionPane.showMessageDialog(null, "Class is filled up!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("registerCourseLimitReached"))
    	{
    		JOptionPane.showMessageDialog(null, "You have reached your Registration Limit!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("registerCourseSuccess"))
    	{
    		JOptionPane.showMessageDialog(null, "Registration Successful!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.equals("dropCourseSuccess"))
    	{
    		JOptionPane.showMessageDialog(null, "Drop Course Successful!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(feedback.equals("dropCourseFailure"))
    	{
    		JOptionPane.showMessageDialog(null, "Unable to drop course.", "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
    	else if(feedback.equals("postGradesSuccess"))
		{
    		JOptionPane.showMessageDialog(null, "Successfully Posted Grades!", "Server Feedback", JOptionPane.INFORMATION_MESSAGE);
		}
    	else if(feedback.equals("postGradesFailure"))
		{
    		JOptionPane.showMessageDialog(null, "Unable to Post Grades!", "Server Feedback", JOptionPane.ERROR_MESSAGE);
		}
		else
    	{
    		JOptionPane.showMessageDialog(null, feedback, "Server Feedback", JOptionPane.ERROR_MESSAGE);
    	}
	}
}
