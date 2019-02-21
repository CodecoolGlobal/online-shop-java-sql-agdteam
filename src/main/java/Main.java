import java.io.Console;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.mainLoop();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Number: ");
		int number = Integer.parseInt(scanner.next());
		System.out.println(number + " <--- number");


		System.out.print("String: ");
		scanner.nextLine();
		String string = scanner.nextLine();
		System.out.println(string + " <--- string");

		System.out.print("String: ");
		scanner.nextLine();
		string = scanner.nextLine();
		System.out.println(string + " <--- string");


	}

	public static String forTest(String string) {
		return string;
	}
}


