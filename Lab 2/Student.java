/**
 * Student class
 * @author Adibov
 * @version 1.0
 */
public class Student {
	// the student’s first name
	private String firstName;
	// the student’s last name
	private String lastName;
	// the student ID
	private String id;
	//the grade
	private int grade;
   
	/**
	 * Constructor for making a student with zero grade
	 * @param _firstName_ firstName of the student
	 * @param _lastName_ lastName of the student
	 * @param _id_ id of the student
	 */
	public Student(String _firstName_, String _lastName_, String _id_) {
		firstName = _firstName_;
		lastName = _lastName_;
		id = _id_;
		grade = 0;
	}

	/**
	* Get the first name of student
	* @return firstName field
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
	* Get the last name of student
	* @return lastName field
	*/
	public String getLastName() {
		return lastName;
	}

	/**
	* Get the id of student
	* @return id field
	*/
	public String getId() {
		return id;
	}

	/**
	* Get the grade of student
	* @return grade field
	*/
	public int getGrade() {
		return grade;
	}

	/**
	 * @param _firstName_ set first name of a student
	 */
	public void setFirstName(String _firstName_) {
		firstName = _firstName_;
	}

	/**
	 * @param _lastName_ set last name of a student
	 */
	public void setLastName(String _lastName_) {
		lastName = _lastName_;
	}

	/**
	 * @param _id_ set id of a student
	 */
	public void setId(String _id_) {
		id = _id_;
	}

	/**
	 * @param _grade_ set grade of a student
	 */
	public void setGrade(int _grade_) {
		grade = _grade_;
	}

	/**
	 * Print the student’s last name and ID number to the output terminal.
	*/
	public void print() {
		System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
	}
}
