public class Run {
	public static void main(String[] args) {
		ClockDisplay sample = new ClockDisplay();
		while (true) {
			System.out.println(sample.getTime());
			sample.timeTick();
			if (sample.getTime().equals("00:00"))
				break;
		}
	}
}