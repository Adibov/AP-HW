/**
 * Lab class
 * @author Adibov
 * @version 1.0
 */
public class Lab {
	private Student[] students;
	private int average;
	private String day;
	private int capacity;
	private int currentSize;

	/**
	 * Lab Constructor for making a Lab object
	 * @param _capacity_ Lab capacity
	 * @param _day_ Lab day?
	 */
	public Lab(int _capacity_, String _day_) {
		students = new Student[_capacity_];
		average = 0;
		day = _day_;
		capacity = _capacity_;
		currentSize = 0;
	}


	/**
	 * Add student to lab
	 * @param _student_
	 */
	public void enrollStudent(Student _student_) {
		if (currentSize < capacity) {
			students[currentSize] = _student_;
			currentSize++;
		} 
		else {
			System.out.println("Lab is full!!!");
		}
		// _student_ = new Student("mammad", "bagher", "9931087");
		// _student_.setLastName("sadegh");
		calculateAvg();
	}


	/**
	 * Prints Lab's students information and average
	 */
	public void print() {
		System.out.println("Lab Students:");
		for (int i = 0; i < currentSize; i++)
			students[i].print();
		System.out.println("Average: " + average);
	}

	/**
	 * Get list of the Lab's students
	 * @return Array of students
	 */
	public Student[] getStudents() {
		return students;
	}

	/**
	 * Set students
	 * @param _students_ New students array
	 */
	public void setStudents(Student[] _students_) {
		students = _students_.clone();
	}

	/**
	 * Get average of students grade
	 * @return Average
	 */
	public int getAvg() {
		int result = 0;
		for (int i = 0; i < currentSize; i++)
			result += students[i].getGrade();
		return (result / currentSize);
	}

	/**
	 * Update average
	 */
	public void calculateAvg() {
		average = getAvg();
	}

	/**
	 * Get day
	 * @return day in String format
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Set day
	 * @param _day_
	 */
	public void setDay(String _day_) {
		day = _day_;
	}

	/**
	 * Get capacity
	 * @return Lab's capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Set capacity
	 * @param _capacity_
	 */
	public void setCapacity(int _capacity_) {
		capacity = _capacity_;
	}
   }
   