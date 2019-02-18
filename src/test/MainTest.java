import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

	@Test
	void forTest() {
		assertEquals(Main.forTest("test"), "test");
	}
}