/**
 * Main code to run program
 * @author Adibov
 * @version 1.0
 */
public class Run {
	public static void main(String[] args) {
		Student std1 = new Student("Ehsan","Edalat", "9031066");
		Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
		Student std3 = new Student("Ahmad", "Asadi", "9031054");

		std1.print();
		std1.setGrade(15);
		std1.print();

		std2.print();
		std2.setGrade(11);
		std2.print();

		std3.print();
		std3.setFirstName("HamidReza");
		std3.print();

		System.out.println("-----------------------");
		Lab lb1 = new Lab(30, "Saturday");
		lb1.enrollStudent(std1);
		lb1.enrollStudent(std2);
		lb1.enrollStudent(std3);
		lb1.print();
		std2.print();


		System.out.println("-----------------------");
		Faculty fc1 = new Faculty(50);
		fc1.enrollLab(lb1);
		fc1.print();
	}
}