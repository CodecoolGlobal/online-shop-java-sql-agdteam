package Service;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ServiceMainTest {

	@Test
	void handleLogin() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.println(string);
	}

	@Test
	void handleWithOutLogin() {
	}

	@Test
	void handleCreateAccount() {
	}
}