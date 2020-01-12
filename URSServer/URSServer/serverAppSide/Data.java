package serverAppSide;

import java.util.ArrayList;
import java.util.List;

public class Data 
{
	static ArrayList<Faculty> faculties = University.getFaculties();
	
	public static void dataLoad()
	{
		
		FacultyMember facultyMember0 = new FacultyMember("John", "Sing", 745615, "john@lakeheadu.ca", "[21-AUG-1997]", 665247, "55 Courtney Park", "password", "FullTime", "Administrator", 190000, faculties.get(0));
		FacultyMember facultyMember1 = new FacultyMember("Kelly", "Dalov", 755311, "kelly@lakeheadu.ca", "[16-JUN-1969]", 555284, "72 Raman Street", "password", "PartTime", "Instructor", 120000,  faculties.get(0));
		FacultyMember facultyMember2 = new FacultyMember("Brianna", "Prie", 454213, "brianna@lakeheadu.ca", "[24-APR-1991]", 254885, "29 Berkley Road", "password", "FullTime", "lecturer", 155000,  faculties.get(1));
		FacultyMember facultyMember3 = new FacultyMember("Kendal", "Plateu", 646413, "kendal@lakeheadu.ca", "[03-NOV-1987]", 784508, "31 Queen Bwld", "password", "PartTime", "Associate Professor", 160000,  faculties.get(1));
		FacultyMember facultyMember4 = new FacultyMember("Jordan", "Mill", 574703, "jordan@lakeheadu.ca", "[30-SEP-1972]", 144109, "49 Harpreet Cresent", "password", "FullTime", "Dean", 225500,  faculties.get(2));
		FacultyMember facultyMember5 = new FacultyMember("Meril", "Thompson", 663207, "meril@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(2));
		FacultyMember facultyMember6 = new FacultyMember("Dave", "Kellermen", 362514, "dave@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(3));
		FacultyMember facultyMember7 = new FacultyMember("Sarah", "Huane", 656457, "sarah@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(3));
		FacultyMember facultyMember8 = new FacultyMember("Javi", "Chen", 564315, "javi@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(4));
		FacultyMember facultyMember9 = new FacultyMember("Jahnani", "Krish", 663265, "jahnani@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(4));
		FacultyMember facultyMember10 = new FacultyMember("Krishna", "McDonald", 663206, "krishna@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(5));
		FacultyMember facultyMember11 = new FacultyMember("Phill", "Loock", 644207, "phill@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(5));
		FacultyMember facultyMember12 = new FacultyMember("Eric", "Pablo", 754320, "eric@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(6));
		FacultyMember facultyMember13 = new FacultyMember("Juan", "Marqez", 664207, "Juan@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(6));
		FacultyMember facultyMember14 = new FacultyMember("Julio", "Huang", 214507, "julio@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(7));
		FacultyMember facultyMember15 = new FacultyMember("Jose", "Kapoor", 213207, "jose@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(7));
		FacultyMember facultyMember16 = new FacultyMember("Nat", "Singh", 667417, "nat@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(8));
		FacultyMember facultyMember17 = new FacultyMember("Bharav", "McMillan", 666207, "bharav@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(8));
		FacultyMember facultyMember18 = new FacultyMember("Pradyuman", "Hasson", 664407, "pradyuman@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(9));
		FacultyMember facultyMember19 = new FacultyMember("Vishwas", "Das", 656207, "vishwas@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(9));
		FacultyMember facultyMember20 = new FacultyMember("Jeoffrey", "Das", 212107, "jeoffrey@lakeheadu.ca", "[25-DEC-2004]", 734154, "113 Muggles Arc", "password", "PartTime", "Magician", 777777,  faculties.get(9));
		
		ArrayList<FacultyMember> fac0 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac1 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac2 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac3 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac4 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac5 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac6 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac7 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac8 = new ArrayList<FacultyMember>();
		ArrayList<FacultyMember> fac9 = new ArrayList<FacultyMember>();
		
		//faculties.get(0).setFacultyMembers(fac0);
		//faculties.get(1).setFacultyMembers(fac0);
		//faculties.get(0).setFacultyMembers(fac1);

		fac0.add(facultyMember0);
		fac0.add(facultyMember1);
		fac1.add(facultyMember2);
		fac1.add(facultyMember3);
		fac2.add(facultyMember4);
		fac2.add(facultyMember5);
		fac3.add(facultyMember6);
		fac3.add(facultyMember7);
		fac4.add(facultyMember8);
		fac4.add(facultyMember9);
		fac5.add(facultyMember10);
		fac5.add(facultyMember11);
		fac6.add(facultyMember12);
		fac6.add(facultyMember13);
		fac7.add(facultyMember14);
		fac7.add(facultyMember15);
		fac8.add(facultyMember16);
		fac8.add(facultyMember17);
		fac9.add(facultyMember18);
		fac9.add(facultyMember19);
		fac1.add(facultyMember20);

		faculties.get(0).setFacultyMembers(fac0);
		faculties.get(1).setFacultyMembers(fac1);
		faculties.get(2).setFacultyMembers(fac2);
		faculties.get(3).setFacultyMembers(fac3);
		faculties.get(4).setFacultyMembers(fac4);
		faculties.get(5).setFacultyMembers(fac5);
		faculties.get(6).setFacultyMembers(fac6);
		faculties.get(7).setFacultyMembers(fac7);
		faculties.get(8).setFacultyMembers(fac8);	
		faculties.get(9).setFacultyMembers(fac9);

		Schedule schedule0 = new Schedule("Planet Earth", "Wednesday", "9", "AM", "11", "AM");
		Schedule schedule1 = new Schedule("Mechanics 1", "Monday", "1", "PM", "3", "PM");
		Schedule schedule2 = new Schedule("Electronics 2", "Thursday", "1", "PM", "3", "PM");
		
		//software Engineering Schedules
		/************************************************************************************************************/

		Schedule schedule5 = new Schedule("Discrete Math", "Monday", "9", "AM", "11", "AM");
		Schedule schedule6 = new Schedule("Chemistry", "Monday", "9", "AM", "11", "AM");
		Schedule schedule7 = new Schedule("Software Engineering Design", "Monday", "11:10", "AM", "12:35", "PM");
		Schedule schedule8 = new Schedule("Semiconductor Physics", "Monday", "2:05", "PM", "4:10", "PM");
		Schedule schedule3 = new Schedule("Analysis B", "Tuesday", "10", "AM", "1", "PM");
		Schedule schedule4 = new Schedule("Probability", "Friday", "7", "PM", "9", "PM");
		Schedule schedule9 = new Schedule("Java Programming", "Wednesday", "9", "AM", "11", "AM");
		Schedule schedule10 = new Schedule("Analysis A", "Wednesday", "11:15", "AM", "12:50", "PM");
		Schedule schedule11 = new Schedule("Object Oriented Programming", "Wednesday", "12:55", "AM", "1:25", "PM");
		Schedule schedule12 = new Schedule("Data Management and Information Systems", "Wednesday", "1:30", "PM", "3:05", "PM");
		Schedule schedule13 = new Schedule("Software Engineering", "Wednesday", "4:10", "PM", "6:05", "PM");
		Schedule schedule14 = new Schedule("Object Oriented Graphical User Interface", "Wednesday", "7:00", "PM", "8:50", "PM");
		Schedule schedule15 = new Schedule("Computer Hardware and Software Systems", "Thursday", "9", "AM", "11", "AM");
		Schedule schedule16 = new Schedule("Technical Project", "Thursday", "1", "PM", "3", "PM");
		Schedule schedule17 = new Schedule("Degree Project", "Friday", "9", "AM", "11", "AM");
		Schedule schedule18 = new Schedule("Principles of Operating Systems", "Friday", "12", "AM", "1:55", "AM");


		List<Schedule> sch0 = new ArrayList<Schedule>();
		List<Schedule> sch1 = new ArrayList<Schedule>();
		List<Schedule> sch2 = new ArrayList<Schedule>();
		List<Schedule> sch3 = new ArrayList<Schedule>();
		List<Schedule> sch4 = new ArrayList<Schedule>();
		List<Schedule> sch5 = new ArrayList<Schedule>();
		List<Schedule> sch6 = new ArrayList<Schedule>();
		List<Schedule> sch7 = new ArrayList<Schedule>();
		List<Schedule> sch8 = new ArrayList<Schedule>();
		List<Schedule> sch9 = new ArrayList<Schedule>();
		List<Schedule> sch10 = new ArrayList<Schedule>();
		List<Schedule> sch11 = new ArrayList<Schedule>();
		List<Schedule> sch12 = new ArrayList<Schedule>();
		List<Schedule> sch13 = new ArrayList<Schedule>();
		List<Schedule> sch14 = new ArrayList<Schedule>();
		List<Schedule> sch15 = new ArrayList<Schedule>();
		List<Schedule> sch16 = new ArrayList<Schedule>();
		List<Schedule> sch17 = new ArrayList<Schedule>();
		List<Schedule> sch18 = new ArrayList<Schedule>();
		
		sch0.add(schedule0);
		sch1.add(schedule1);
		sch2.add(schedule2);
		
		//software Engineering Schedules
		/************************************************************************************************************/

		sch3.add(schedule3);
		sch4.add(schedule4);
		sch5.add(schedule5);
		sch6.add(schedule6);
		sch7.add(schedule7);
		sch8.add(schedule8);
		sch9.add(schedule9);
		sch10.add(schedule10);
		sch11.add(schedule11);
		sch12.add(schedule12);
		sch13.add(schedule13);
		sch14.add(schedule14);
		sch15.add(schedule15);
		sch16.add(schedule16);
		sch17.add(schedule17);
		sch18.add(schedule18);

		List<Department> departmentList = new ArrayList<Department>();

		/************************************************************************************************************/
		//Engineering
		Department depart0 = new Department("Software Engineering",4,faculties.get(2));
		Department depart4 = new Department("Biomedical Engineering",4,faculties.get(2));
		Department depart1 = new Department("Computer Science",3,faculties.get(2));
		Department depart6 = new Department("Chemical Engineering",4,faculties.get(2));
		Department depart7 = new Department("Mechanical Engineering",3,faculties.get(2));
		Department depart8 = new Department("Electrical Engineering",4,faculties.get(2));
		Department depart9 = new Department("Civil Engineering",3,faculties.get(2));
		Department depart10 = new Department("Environmental Engineering",3,faculties.get(2));

		/************************************************************************************************************/

		departmentList.add(depart0);
		departmentList.add(depart4);
		departmentList.add(depart1);
		departmentList.add(depart6);
		departmentList.add(depart7);
		departmentList.add(depart8);
		departmentList.add(depart9);
		departmentList.add(depart10);

		/************************************************************************************************************/

		//Science and Environment Studies
		Department depart11 = new Department("Biology",3,faculties.get(8));
		Department depart12 = new Department("Physics",3,faculties.get(8));
		Department depart13 = new Department("Chemistry",3,faculties.get(8));
		Department depart14 = new Department("Life Sciences",3,faculties.get(8));
		Department depart15 = new Department("Health Sciences",3,faculties.get(8));
		Department depart16 = new Department("Environmental Studies",3,faculties.get(8));
		Department depart17 = new Department("Natural Sciences",3,faculties.get(8));
		Department depart18 = new Department("Water Resourse Science",3,faculties.get(8));

		//Faculty of Business Administration
		Department depart22 = new Department("Bachelor of Administration",3,faculties.get(0));
		Department depart23 = new Department("Bachelor of Commerce",3,faculties.get(0));
		Department depart24 = new Department("Master of Management",3,faculties.get(0));

		//Social Sciences and Humanities
		Department depart2 = new Department("Criminology",3,faculties.get(9));
		Department depart19 = new Department("English",3,faculties.get(9));
		Department depart20 = new Department("Hitory",3,faculties.get(9));
		Department depart21 = new Department("Indidenous Studies",3,faculties.get(9));
		Department depart25 = new Department("Languages",3,faculties.get(9));
		Department depart26 = new Department("Media Studies",3,faculties.get(9));
		Department depart27 = new Department("Music",3,faculties.get(9));
		Department depart28 = new Department("Philosophy",3,faculties.get(9));
		Department depart29 = new Department("Polical Science",3,faculties.get(9));
		Department depart30 = new Department("Visual Arts",3,faculties.get(9));
		Department depart31 = new Department("Socioligy",3,faculties.get(9));

		//Faculty of Law
		Department depart3 = new Department("Justice and Law",4,faculties.get(5));
		Department depart5 = new Department("Social Law",4,faculties.get(5));

		//Faculty of Natural Rescources and Management
		Department depart32 = new Department("Fish and Wildlife",3,faculties.get(7));
		Department depart33 = new Department("Pathology",3,faculties.get(7));
		Department depart34 = new Department("Entomology",3,faculties.get(7));
		Department depart35 = new Department("Dendrology",3,faculties.get(7));
		Department depart36 = new Department("Economics",3,faculties.get(7));
		Department depart37 = new Department("Mensuration",3,faculties.get(7));
		Department depart38 = new Department("Remote Sensing",3,faculties.get(7));
		Department depart39 = new Department("Photogrammetry",3,faculties.get(7));

		//Faculty of Graduate studies
		Department depart40 = new Department("Master in Biology",3,faculties.get(3));
		Department depart41 = new Department("Master in Business Administration (MBA)",3,faculties.get(3));
		Department depart42 = new Department("Master in Chemistry",3,faculties.get(3));
		Department depart43 = new Department("Master in Computer Science",3,faculties.get(3));
		Department depart44 = new Department("Master in Economics",3,faculties.get(3));
		Department depart45 = new Department("Master in Education",3,faculties.get(3));
		Department depart46 = new Department("Master in Health Sciences",3,faculties.get(3));
		Department depart47 = new Department("Master in Physics",3,faculties.get(3));
		Department depart48 = new Department("Master in Sociology",3,faculties.get(3));
		Department depart49 = new Department("Master in Kinesiology",3,faculties.get(3));

		//Faculty of Health and Behavioural Sciences
		Department depart50 = new Department("Health Sciences",3,faculties.get(4));
		Department depart51 = new Department("Kinesiology",3,faculties.get(4));
		Department depart52 = new Department("Nursing",3,faculties.get(4));
		Department depart53 = new Department("Psychology",3,faculties.get(4));
		Department depart54 = new Department("Social Work",3,faculties.get(4));
		
		//Faculty of Medical school
		Department depart55 = new Department("Clinical Sciences",3,faculties.get(6));
		Department depart56 = new Department("Human Sciences",3,faculties.get(6));
		Department depart57 = new Department("Medical Sciences",3,faculties.get(6));
		
		//Faculty of Education
		Department depart58 = new Department("Bechelars of Education",3,faculties.get(1));
		Department depart59 = new Department("Marsters of Education",3,faculties.get(1));

		List<StudentMember> depart0Student = new ArrayList<StudentMember>();
		List<StudentMember> depart1Student = new ArrayList<StudentMember>();
		List<StudentMember> depart2Student = new ArrayList<StudentMember>();
		List<StudentMember> depart3Student = new ArrayList<StudentMember>();
		List<StudentMember> depart4Student = new ArrayList<StudentMember>();
		List<StudentMember> depart5Student = new ArrayList<StudentMember>();
		
		List<StudentMember> student0 = new ArrayList<StudentMember>();
		List<StudentMember> student1 = new ArrayList<StudentMember>();
		List<StudentMember> student2 = new ArrayList<StudentMember>();
		List<StudentMember> student3 = new ArrayList<StudentMember>();
		List<StudentMember> student4 = new ArrayList<StudentMember>();
		List<StudentMember> student5 = new ArrayList<StudentMember>();

		//Software Engineering depart0
		/************************************************************************************************************/
		Course course0 = new Course("Chemistry", "CHEM", 1379, "Summer", "SU", 150, depart0, sch6, 1, "Study how atoms and molecules bond. Its fun stuff");
		Course course2 = new Course("Software Engineering Design", "SOFT", 3050, "Fall", "FA",50, depart0, sch7, 1, "Learn to design software and experince some coding.");
		Course course3 = new Course("Semiconductor Physics", "PHYS", 1070, "Winter", "WA", 110, depart0, sch8, 1, "Learn to be dope");
		Course course10 = new Course("Analysis B", "MATH", 2054, "Winter", "WA", 90, depart0, sch3, 1, "Have fun");
		Course course11 = new Course("Probability", "MATH", 2058, "Fall", "FA", 90, depart0, sch4, 1, "Have fun");
		Course course12 = new Course("Discrete Math", "MATH", 2075, "Fall", "FA", 90, depart0, sch5, 1, "Have fun");
		Course course14 = new Course("Java Programming", "COMP", 2065, "Fall", "FA", 90, depart0, sch9, 2, "Have fun");
		Course course13 = new Course("Analysis A", "MATH", 2099, "Fall", "FA", 90, depart0, sch10, 2, "Mathematics");
		Course course18 = new Course("Object Oriented Programming", "ESOF", 2775, "Fall", "FA", 90, depart0, sch11, 2, "Have fun");
		Course course19 = new Course("Data Management and Information Systems", "ESOF", 2254, "Fall", "FA", 40, depart0, sch12, 2, "Data mining");
		Course course20 = new Course("Software Engineering", "ESOF", 2670, "Fall", "FA", 30, depart0, sch13, 2, "Data mining");
		Course course21 = new Course("Object Oriented Graphical User Interface", "ESOF", 2570, "Winter", "WA", 30, depart0, sch14, 2, "Data mining");
		Course course22 = new Course("Computer Hardware and Software Systems", "ESOF", 2571, "Winter", "WA", 30, depart0, sch15, 2, "Data mining");
		Course course23 = new Course("Technical Project", "ESOF", 2571, "Winter", "WA", 30, depart0, sch16, 2, "Data mining");
		Course course24 = new Course("Degree Project", "ESOF", 3577, "Fall", "FA", 30, depart0, sch17, 3, "Data mining");
		Course course25 = new Course("Principles of Operating Systems", "ESOF", 3871, "Fall", "FA", 30, depart0, sch18, 3, "Data mining");

		Instructor instructor = new Instructor(facultyMember17);
		course2.setInstructor(instructor);
		instructor.getFacultyMember().getAssignedCourses().add(course2);
		
		Chair chair = new Chair(facultyMember17);
		depart0.setChair(chair);
		chair.getFacultyMember().setDepartment(depart0);
		
		//Computer Science Depart1
		/************************************************************************************************************/
		
		depart1.getCourses().add(course12);
		Course course26 = new Course("Elementary Computing", "COMP", 0411, "Fall", "FA", 90, depart1, sch4, 1, "The development of good programs");
		Course course27 = new Course("Computer Programming I", "COMP", 1411 , "Winter", "WA", 90, depart1, sch4, 1, "The development of good programs");
		Course course28 = new Course("Computer Programming II", "COMP", 1431 , "Winter", "WA", 90, depart1, sch4, 1, "The development of good programs");
		Course course29 = new Course("Data Structures", "COMP", 2412 , "Fall", "FA", 90, depart1, sch4, 2, "The development of good programs");
		Course course30 = new Course("Mobile Computing Technology", "COMP", 2430 , "Fall", "FA", 90, depart1, sch4, 2, "The development of good programs");
		Course course31 = new Course("Introduction to Computer Architecture", "COMP", 2453  , "Winter", "WA", 90, depart1, sch4, 2, "The development of good programs");
		Course course32 = new Course("Introduction to Assembly Language and Operating Systems", "COMP", 2476   , "Winter", "WA", 90, depart1, sch4, 2, "The development of good programs");
		Course course33 = new Course("Mobile Computing Technology", "COMP", 2430 , "Fall", "FA", 90, depart1, sch4, 2, "The development of good programs");
		Course course34 = new Course("Database Management Systems ", "COMP", 3413 , "Fall", "FA", 90, depart1, sch4, 3, "The development of good programs");
		Course course35 = new Course("Software Engineering ", "COMP", 3415 , "Fall", "FA", 90, depart1, sch4, 3, "The development of good programs");
		Course course36 = new Course("Operating SystemsOperating Systems", "COMP", 3473 , "Winter", "WA", 90, depart1, sch4, 3, "The development of good programs");

		//Chemical Engineering depart6
		/************************************************************************************************************/		
		
		depart6.getCourses().add(course0);
		depart6.getCourses().add(course13);
		depart6.getCourses().add(course10);
		Course course37 = new Course("Unit Operations I", "CHEM", 1554 , "Fall", "FA", 90, depart6, sch4, 1, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course38 = new Course("Applied Chemical Thermodynamics", "CHEM", 2330 , "Fall", "FA", 90, depart6, sch4, 2, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course39 = new Course("Unit Operations II", "CHEM", 2331  , "Winter", "WA", 90, depart6, sch4, 2, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course40 = new Course("Hydrocarbon Processes", "CHEM", 2455  , "Winter", "WA", 90, depart6, sch4, 2, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course41 = new Course("Material and Energy Balances", "CHEM", 3070  , "Fall", "FA", 90, depart6, sch4, 3, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course42 = new Course("Mass Transfer Separations", "CHEM", 3338  , "Fall", "FA", 90, depart6, sch4, 3, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course43 = new Course("Materials Science", "CHEM", 4032  , "Winter", "WA", 90, depart6, sch4, 4, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course44 = new Course("Plant Design Economics and Management", "CHEM", 4132  , "Winter", "WA", 90, depart6, sch4, 4, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course45 = new Course("Chemical Reactor Design", "CHEM", 4150  , "Fall", "FA", 90, depart6, sch4, 4, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course46 = new Course("Process Control Fundamentals", "CHEM", 4152  , "Fall", "FA", 90, depart6, sch4, 4, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course47 = new Course("Chemical Plant Design", "CHEM", 4432  , "Winter", "WA", 90, depart6, sch4, 4, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course48 = new Course("Introduction to Industrial Chemical Processes", "CHEM", 1150  , "Winter", "WA", 90, depart6, sch4, 1, "Study of the heat transfer unit operations important to chemical engineering.");
		Course course49 = new Course("Introduction to Chemical Engineering Calculations", "CHEM", 1135  , "Fall", "FA", 90, depart6, sch4, 1, "Study of the heat transfer unit operations important to chemical engineering.");

		//Civil Engineering depart9
		/************************************************************************************************************/		

		Course course50 = new Course("Dynamics I", "CIVL", 1111 , "Fall", "FA", 90, depart9, sch4, 1, "Principles of dynamics and their application to engineering problems.");
		Course course51 = new Course("Statics", "CIVL", 1230 , "Fall", "FA", 90, depart9, sch4, 1, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course52 = new Course("Mechanics of Materials I", "CIVL", 1233 , "Winter", "WA", 90, depart9, sch4, 1, "Concepts of stress and strain; elasticity; Poisson's ratio; axial loading and deformation; thermal stresses.");
		Course course53 = new Course("Surveying ", "CIVL", 1235 , "Winter", "WA", 90, depart9, sch4, 1, "Elementary plane surveying.");
		Course course54 = new Course("Mechanics of Materials II", "CIVL", 1533 , "Fall", "FA", 90, depart9, sch4, 1, "Transformation equations for plane stress and plane strain.");
		Course course55 = new Course("Theory of Structures", "CIVL", 1630 , "Fall", "FA", 90, depart9, sch4, 1, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course56 = new Course("Fluid Mechanics", "CIVL", 1635  , "Winter", "WA", 90, depart9, sch4, 1, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course57 = new Course("Steel and Reinforced Concrete Design", "CIVL", 2011  , "Fall", "FA", 90, depart9, sch4, 2, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course58 = new Course("Soil Mechanics", "CIVL", 2012 , "Fall", "FA", 90, depart9, sch4, 2, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course59 = new Course("Construction Practice", "CIVL", 2135 , "Winter", "WA", 90, depart9, sch4, 2, "An introduction to the management of construction projectsAn introduction to the management of construction projects.");
		Course course60 = new Course("Highway Design", "CIVL", 2138 , "Winter", "WA", 90, depart9, sch4, 2, "The fundamentals of statics, including the resolution and composition of forces.");
		Course course61 = new Course("Water Supply and Waste Systems", "CIVL", 2431 , "Fall", "FA", 90, depart9, sch4, 2, "The fundamentals of statics, including the resolution and composition of forces.");
		
		//Electrical Engineering depart8
		/************************************************************************************************************/		
		
		Course course9 = new Course("Electronics 2", "ELEC", 2057 , "Winter", "WA", 90, depart8, sch4, 2, "Have fun");
		Course course62 = new Course("Introduction to Engineering Design", "ELEC", 1133 , "Winter", "WA", 90, depart8, sch4, 1, "Introduction to the principles and practice of engineering design through the examination of selected current topics");
		Course course63 = new Course("Introduction to Microcontrollers", "ELEC", 1232 , "Fall", "FA", 90, depart8, sch4, 1, "Fundamentals of electromagnetism and circuit analysis");
		Course course64 = new Course("Electric Circuit Theory I", "ELEC", 1236 , "Fall", "FA", 90, depart8, sch4, 1, "Basic meter movements. Instruments such as voltmeters, ammeters, multi-meters");
		Course course65 = new Course("Electrical Measurements and Measuring Instruments", "ELEC", 1252 , "Winter", "WA", 90, depart8, sch4, 1, "Basic meter movements.");
		Course course66 = new Course("Electric Circuit Theory II", "ELEC", 1536 , "Winter", "WA", 90, depart8, sch4, 1, "Basic meter movements.");
		Course course67 = new Course("Electronics I", "ELEC", 1634 , "Fall", "FA", 90, depart8, sch4, 1, "Semiconductor theory applied to p-n junctions.");
		Course course68 = new Course("Computer Logic Circuits", "ELEC", 1637 , "Fall", "FA", 90, depart8, sch4, 1, "Introduction to fundamental concepts of digital logic circuits.");
		Course course69 = new Course("Electronics II", "ELEC", 2132 , "Winter", "WA", 90, depart8, sch4, 2, "ultistage and differential amplifiers; power amplifiers.");
		Course course70 = new Course("Electrical and Electronics Technology", "ELEC", 2151 , "Winter", "WA", 90, depart8, sch4, 2, "Basic electronic materials-physical concepts.");
		Course course71 = new Course("Electric Machines I", "ELEC", 2258 , "Fall", "FA", 90, depart8, sch4, 2, "Safety measures in working with AC and DC machines.");
		Course course72 = new Course("Power Electronics I", "ELEC", 2430  , "Winter", "WA", 90, depart8, sch4, 2, "Basic meter movements.");
		Course course73 = new Course("Circuit Theory and Design I", "ELEC", 3013 , "Winter", "WA", 90, depart8, sch4, 3, "Operational calculus applied to network analysis.");
		Course course74 = new Course("Circuit Analysis and Design I", "ELEC", 3310 , "Fall", "FA", 90, depart8, sch4, 3, "Circuit Analysis and Synthesis using Laplace Transforms.");
		Course course75 = new Course("Embedded Systems", "ELEC", 3312 , "Winter", "WA", 90, depart8, sch4, 3, "Characteristics and design of embedded systems.");
		Course course76 = new Course("Control Systems", "ELEC", 3314 , "Winter", "WA", 90, depart8, sch4, 3, "Transfer functions; block diagram simplification.");

		//Mechanical Engineering depart7
		/************************************************************************************************************/		

		Course course77 = new Course("Materials and Processes", "MECH", 1553 , "Fall", "FA", 90, depart7, sch4, 1, "Engineering materials; properties of materials.");
		Course course78 = new Course("Introduction to Engineering Design", "MECH", 1112 , "Fall", "FA", 90, depart7, sch4, 1, "Covers design techniques.");
		Course course79 = new Course("Mechanical Engineering Drawing", "MECH", 1731 , "Winter", "WA", 90, depart7, sch4, 1, "Properties of fluids. Fluid statics.");
		Course course80 = new Course("Machine Design", "MECH", 2333 , "Winter", "WA", 90, depart7, sch4, 2, "The application of the theory of mechanics of materials to the design of machine elements.");
		Course course81 = new Course("Thermal Sciences", "MECH", 2518  , "Fall", "FA", 90, depart7, sch4, 2, "Basic concepts of thermodynamics.");
		Course course82 = new Course("Heating, Ventilating and Air Conditioning", "MECH", 2651 , "Fall", "FA", 90, depart7, sch4, 2, "Thermodynamic considerations affecting human comfort.");
		Course course83 = new Course("Intermediate Mechanics of Materials ", "MECH", 3055 , "Winter", "WA", 90, depart7, sch4, 3, "Three dimensional concept of stress and strain.");
		Course course84 = new Course("Fluid Dynamics", "MECH", 3337  , "Winter", "WA", 90, depart7, sch4, 3, "Principles of dynamics.");
		Course course85 = new Course("Applied Heat Transfer", "MECH", 3454 , "Fall", "FA", 90, depart7, sch4, 3, "Principles of conduction, convection and thermal radiation.");
		Course course86 = new Course("Computational Methods and Modeling", "MECH", 3559 , "Winter", "WA", 90, depart7, sch4, 1, "Field problems in mechanical engineering.");
		Course course87 = new Course("Principles of Engineering Mechanics", "MECH", 1552 , "Fall", "FA", 90, depart7, sch4, 1, "Analysis of displacements.");
		Course course88 = new Course("Engineering Measurements and Instrumentations", "MECH", 2434 , "Fall", "FA", 90, depart7, sch4, 1, "Introduces the fundamentals of measurements and the principles of instrumentation in engineering applications.");

		//Environment Engineering derpart10
		/************************************************************************************************************/		
		
		Course course89 = new Course("Fluid Dynamics", "MECH", 3337  , "Winter", "WA", 90, depart7, sch4, 3, "Principles of dynamics.");

		
		Course course1 = new Course("Biology", "BIOL", 1150, "Spring", "SP" ,150, depart10, sch1, 1, "Learn about human body and beyond");
		Course course4 = new Course("Mechanics of fluids", "MECH", 2055, "Fall", "FA", 90, depart4, sch4, 1, "Have fun");
		Course course5 = new Course("Thermodynamics", "CIVL", 3021, "Summer", "SU", 110, depart5, sch5, 1, "presure and temperaturen with a twist of math");
		Course course6 = new Course("Paranormal Studies", "COEL", 1055, "Winter", "WA", 190, depart4, sch4, 1, "Have fun");
		Course course7 = new Course("Planet Earth", "GEOL", 1111, "Fall", "FA", 180, depart4, sch4, 2, "Study Rocks");
		Course course8 = new Course("Mechanics 1", "MECH", 1055, "Fall", "FA", 70, depart4, sch4, 2, "Have fun");
		Course course15 = new Course("Structures", "CIVL", 2055, "Fall", "FA", 90, depart4, sch4, 2, "Have fun");
		Course course16 = new Course("Highway Design", "CIVL", 2055, "Fall", "FA", 90, depart4, sch4, 2, "Study of highways");
		Course course17 = new Course("Hydrology", "CIVL", 3071, "Fall", "FA", 90, depart4, sch4, 2, "Study of water");

		course1.setCapacity(12);
		course1.setEnrollmentCount(12);

		ArrayList<Course> cour0 = new ArrayList<Course>();
		ArrayList<Course> cour1 = new ArrayList<Course>();
		ArrayList<Course> cour2 = new ArrayList<Course>();
		ArrayList<Course> cour3 = new ArrayList<Course>();
		ArrayList<Course> cour4 = new ArrayList<Course>();
		ArrayList<Course> cour5 = new ArrayList<Course>();

		StaffMember staffMember0 = new StaffMember("Jacob", "Singwell", 458766, "john@lakeheadu.ca", "[21-AUG-1997]", 665247, "55 Courtney Park", "password", "FullTime", "Administrator", 190000, "PHD");
		StaffMember staffMember1 = new StaffMember("Kevin", "Kellerman", 985865, "kevin@lakeheadu.ca", "[5-AUG-1897]", 445247, "55 Greenview Park", "password", "PartTime", "Administrator", 190000, "BENG");
		StaffMember staffMember2 = new StaffMember("Jane", "Waterberg", 984275, "jane@lakeheadu.ca", "[14-AUG-1997]", 325247, "55 Blueview Park", "password", "FullTime", "Administrator", 190000, "LOL");
		StaffMember staffMember3 = new StaffMember("Miranda", "Schmeltings", 947824, "miranda@lakeheadu.ca", "[23-AUG-1997]", 755247, "55 Redview Park", "password", "PartTime","Administrator", 190000, "MSC");
		StaffMember staffMember4 = new StaffMember("Jacob", "Sharma", 785324, "jacob@lakeheadu.ca", "[19-AUG-1977]", 545247, "55 Pinkview Park", "password", "FullTime", "Administrator", 190000, "PHD");
		StaffMember staffMember5 = new StaffMember("Ned", "Smith", 999876, "ned@lakeheadu.ca", "[31-AUG-1988]", 955247, "55 Silverview Park", "password", "PartTime", "Administrator",  190000, "BSC");

		StudentMember studentMember0 = new StudentMember("John", "Sing", 943381, "john@lakeheadu.ca", "[21-AUG-1991]", 665247, "55 Courtney Park", "password", depart0, 2);
		StudentMember studentMember1 = new StudentMember("Caitlyn", "Miller", 265531, "kait@lakeheadu.ca", "[21-AUG-1987]", 665247, "55 Courtney Park", "password", depart0, 3);
		StudentMember studentMember2 = new StudentMember("Sarena", "Dosanjh", 546715, "sarena@lakeheadu.ca", "[21-AUG-1979]", 665247, "55 Courtney Park", "password", depart0, 1);
		StudentMember studentMember3 = new StudentMember("Mavin", "Somoa", 445215, "mavin@lakeheadu.ca", "[21-AUG-1948]", 665247, "55 Courtney Park", "password", depart1, 1);
		StudentMember studentMember4 = new StudentMember("Lucy", "ferr", 845615, "lucy@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart1, 3);
		StudentMember studentMember5 = new StudentMember("Damien", "McMillan", 553754, "damien@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart1, 1);
		StudentMember studentMember6 = new StudentMember("Jordan", "Vohra", 965231, "jordan@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart2, 3);
		StudentMember studentMember7 = new StudentMember("Simen", "Klien", 745562, "simen@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart2, 1);
		StudentMember studentMember8 = new StudentMember("Mohamed", "Singh", 637654, "mohamed@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart2, 3);
		StudentMember studentMember9 = new StudentMember("Ismail", "Sharma", 365615, "ismail@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart3, 1);
		StudentMember studentMember10 = new StudentMember("Kim", "Kaur", 536666, "kim@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart3, 3);
		StudentMember studentMember11 = new StudentMember("Salena", "Chahal", 770015, "salena@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart3, 3);
		StudentMember studentMember12 = new StudentMember("Dora", "Sahni", 745618, "dora@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart4, 1);
		StudentMember studentMember13 = new StudentMember("Simmer", "Bishop", 765615, "simmer@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart4, 1);
		StudentMember studentMember14 = new StudentMember("Sunny", "Sandhu", 355615, "sunny@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart4, 3);
		StudentMember studentMember15 = new StudentMember("Rainy", "Adese", 215615, "rainy@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart5, 2);
		StudentMember studentMember16 = new StudentMember("Cyber", "Omlet", 125615, "cyber@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart5, 1);
		StudentMember studentMember17 = new StudentMember("Narcos", "Pablo", 655615, "narcos@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart5, 1);
		StudentMember studentMember18 = new StudentMember("Michal", "Scholfield", 655425, "michal@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart0, 3);
		StudentMember studentMember19 = new StudentMember("Jon", "Fiya", 765325, "jon@lakeheadu.ca", "[21-AUG-1988]", 665247, "55 Courtney Park", "password", depart3, 1);

		PartTime ar0 = new PartTime(studentMember0);
		studentMember0.setAttendanceRole(ar0);
		PartTime ar1 = new PartTime(studentMember1);
		studentMember1.setAttendanceRole(ar1);
		PartTime ar2 = new PartTime(studentMember2);
		studentMember2.setAttendanceRole(ar2);
		PartTime ar3 = new PartTime(studentMember3);
		studentMember3.setAttendanceRole(ar3);
		PartTime ar4 = new PartTime(studentMember4);
		studentMember4.setAttendanceRole(ar4);

		PartTime ar5 = new PartTime(studentMember5);
		studentMember5.setAttendanceRole(ar5);
		PartTime ar6 = new PartTime(studentMember6);
		studentMember6.setAttendanceRole(ar6);
		PartTime ar7 = new PartTime(studentMember7);
		studentMember7.setAttendanceRole(ar7);
		PartTime ar8 = new PartTime(studentMember8);
		studentMember8.setAttendanceRole(ar8);
		PartTime ar9 = new PartTime(studentMember9);
		studentMember9.setAttendanceRole(ar9);

		FullTime ar10 = new FullTime(studentMember10);
		studentMember10.setAttendanceRole(ar10);
		FullTime ar11 = new FullTime(studentMember11);
		studentMember11.setAttendanceRole(ar11);
		FullTime ar12 = new FullTime(studentMember12);
		studentMember12.setAttendanceRole(ar12);
		FullTime ar13 = new FullTime(studentMember13);
		studentMember13.setAttendanceRole(ar13);
		FullTime ar14 = new FullTime(studentMember14);
		studentMember14.setAttendanceRole(ar14);

		FullTime ar15 = new FullTime(studentMember15);
		studentMember15.setAttendanceRole(ar15);
		FullTime ar16 = new FullTime(studentMember16);
		studentMember16.setAttendanceRole(ar16);
		FullTime ar17 = new FullTime(studentMember17);
		studentMember17.setAttendanceRole(ar17);
		FullTime ar18 = new FullTime(studentMember18);
		studentMember18.setAttendanceRole(ar18);
		FullTime ar19 = new FullTime(studentMember19);
		studentMember19.setAttendanceRole(ar19);

		ArrayList<StudentMember> stu0 = new ArrayList<StudentMember>();
		ArrayList<StudentMember> stu1 = new ArrayList<StudentMember>();
		ArrayList<StudentMember> stu2 = new ArrayList<StudentMember>();
		ArrayList<StudentMember> stu3 = new ArrayList<StudentMember>();
		ArrayList<StudentMember> stu4 = new ArrayList<StudentMember>();
		ArrayList<StudentMember> stu5 = new ArrayList<StudentMember>();

		stu0.add(studentMember0);
		stu0.add(studentMember1);
		stu0.add(studentMember2);

		stu1.add(studentMember3);
		stu1.add(studentMember5);
		stu1.add(studentMember6);

		stu2.add(studentMember19);
		stu2.add(studentMember7);
		stu2.add(studentMember8);
		stu2.add(studentMember9);

		stu3.add(studentMember10);
		stu3.add(studentMember11);
		stu3.add(studentMember12);

		stu4.add(studentMember13);
		stu4.add(studentMember14);
		stu4.add(studentMember15);

		stu5.add(studentMember17);
		stu5.add(studentMember18);
		stu5.add(studentMember16);
		stu5.add(studentMember4);
		
		Registration registration0 = new Registration(studentMember1, "A", course2);
		Registration registration1 = new Registration(studentMember2, "B", course2);
		Registration registration2 = new Registration(studentMember3, "B", course2);
		Registration registration3 = new Registration(studentMember4, "A", course2);
		Registration registration4 = new Registration(studentMember5, "C", course2);
		Registration registration5 = new Registration(studentMember6, "B", course2);
		Registration registration6 = new Registration(studentMember7, "C", course2);
		Registration registration7 = new Registration(studentMember8, "B", course2);
		Registration registration8 = new Registration(studentMember9, "D", course2);
		Registration registration9 = new Registration(studentMember10, "E", course2);
		Registration registration10 = new Registration(studentMember11, "C", course2);
		Registration registration11 = new Registration(studentMember12, "E", course2);
		Registration registration12 = new Registration(studentMember13, "D", course2);

		depart0.setDepartmentStudents(stu0);
		depart1.setDepartmentStudents(stu1);
		depart2.setDepartmentStudents(stu2);
		depart3.setDepartmentStudents(stu3);
		depart4.setDepartmentStudents(stu4);
		depart5.setDepartmentStudents(stu5);
	}
	
	public static ArrayList<Faculty> getfacs ()
	{
		return faculties;
	}
	
	public static ArrayList<Faculty> getDepCourses ()
	{
		return faculties;
	}
}
