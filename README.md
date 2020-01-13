# University Registration System (URS)
This is a client-server system which manages student enrollment and class history. <br>
The system is designed for three main user types: Students, Faculty Instructors and Administrative Staffs. <br> 

Student users are expected to be able to search, register and drop course.<br>
They are also expected to be able to view grades and course time tables.<br>

Faculty Instructors are course teachers for specific university departments. <br>
They are are expected to be able to view their assigned courses, post and update student grades. <br> 

The Staffs are higher level university administrative employees with access to configurative functionalities. <br>
They are expected to be able to create student or instructors accounts, create new courses and departments. <br>
They are also expected to be able to assign instructors to specific courses.  <br>

Generic functionalities available to all users include browse programs and deparments as well as search courses. <br>
All users are required to login to the system in order to access non-generic system functionalities.<br>

## Initial Client-Server Setup (URS)
This system can function with multiple clients and a single server. To setup this system, the server should be launched first in order to listen to clients who wish to establish a server connection.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/initialsetup.PNG)

## Browse University Programs & Courses
After client-server connection, this is the first interface provided to the user. Without having to login to the system, users can browse the univeristy faculties, the programs (departments) available in each faculty as well as the courses available in each program.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/browseuniversity.PNG)

## User Authentication
Users are required to be login to the system in order to access non-generic user functionalities. The non-generic user functionalities are features available to all user types (even public users) which do not require user authentication.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/login.PNG)

## Search courses
All users members can search courses by course code, course number, department, year level or semester availability.<br>
This feature can also make the registration process less tedious.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/searchcourse.PNG)

## Student member Dashboard (Main Menu)
When a student logs into the system, this is the initial menu provided with all the functionalities available to the student.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/studentmenu.PNG)

## Course Registration
Students can register for classes. However, limitations depend on the student's year level or the part-time/full-time status.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/registercourse.PNG)

## Student members can also drop a registered course
Students can also decided to drop a registered course if necessary.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/dropcourse.PNG)

## Faculty/Course Instructor Dashboard (Main Menu)
Instructors are provided with a slightly different set of functionalities after authentication.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/facultymenu.PNG)

## Student Grading
Obviously, if an instructor teaches a course, the instructor should be able to post student grades.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/postgradesA.PNG)

## Faculty/Course instructors can view student profile 
Instructors have access to profiles of students. However, only for courses the instructor is assigned to.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/postgradesB.PNG)

## Update Personal Information
After logging into the system, all users have access to their personal profiles if there's need to make any changes.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/personalprofile.PNG)

## Staff Member Dashboard (Main Menu)
When an administrative staff logs into the system, they're also provided with an initial startup menu.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/staffmenu.PNG)

## Staff members have access to data on department students
Every department has a list of enrolled students. Administrative staff members have access to this data.<br>
![alt text](https://github.com/IfeoluwaDavid/University-Registration-System-URS/blob/master/demo/departmentstudents.PNG)
