

public class Main {
	public static void main(String[] args) {
		System.out.println(forTest("test"));
		Controller controller = new Controller();
		controller.mainLoop();
	}

	public static String forTest(String string) {
		return string;
	}
}


