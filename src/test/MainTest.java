import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

	@Test
	void forTest() {
//		Scanner scanner = new Scanner(System.in);
//		String string = scanner.nextLine();
//		System.out.println(string);
		assertEquals(Main.forTest("test"), "test");
	}

	@Test
	void forTest2() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("input: ");
//		String string = scanner.nextLine();
//		System.out.println(string);
		assertEquals(Main.forTest("test"), "test");
	}

	@Test
	void forTest1() {
		assertEquals(10, 10);
	}
}