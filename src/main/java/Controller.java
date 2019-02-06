import Service.*;
import View.View;

public class Controller {
	private ServiceMain serviceMain;
	private View view;

	public Controller(){
		this.serviceMain = new ServiceMain();
		this.view = new View();
	}

	public void mainLoop() {
		int choice;
		do {
			choice = view.getUserMainMenuChoice();
			if (choice == 1) {
				serviceMain.handleLogin();
			} else if (choice == 2) {
				serviceMain.handleWithOutLogin();
			}
		} while (choice != 0);
	}
}
