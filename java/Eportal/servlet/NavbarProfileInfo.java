package Eportal.servlet;

public class NavbarProfileInfo {
	
	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	String Name;
	int RollNo;
	String Email;
	String PNumber;
	String CourseName;
	int CourseUID;
	String teacherName;
	String Temail;
	
	public int getCourseUID() {
		return CourseUID;
	}

	public void setCourseUID(int courseUID) {
		CourseUID = courseUID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTemail() {
		return Temail;
	}

	public void setTemail(String temail) {
		Temail = temail;
	}

	public NavbarProfileInfo()
	{
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPNumber() {
		return PNumber;
	}

	public void setPNumber(String pNumber) {
		PNumber = pNumber;
	}
	
	

}
