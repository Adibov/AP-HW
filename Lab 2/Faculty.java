/**
 * Faculty class
 * @author Adibov
 * @version 1.0
 */
public class Faculty {
	private Lab[] labs;
	private int capacity;
	private int currentSize;

	/**
	 * Faculty class constructor
	 * @param _capacity_
	 */
	public Faculty(int _capacity_) {
		capacity = _capacity_;
		currentSize = 0;
		labs = new Lab[capacity];
	}

	/**
	 * Add _lab_ to faculty
	 * @param _lab_
	 */
	public void enrollLab(Lab _lab_) {
		if (currentSize < capacity) {
			labs[currentSize++] = _lab_;
			return;
		}
		System.out.println("Faculty is full!");
	}

	/**
	 * Get list of the faculty's labs
	 * @return Array of labs
	 */
	public Lab[] getLabs() {
		return labs;
	}

	/**
	 * Get current capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Set current capacity to _capacity_
	 * @param _capacity_
	 */
	public void setCapacity(int _capacity_) {
		capacity = _capacity_;
	}
}