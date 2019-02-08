import Service.*;
import View.View;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.document.TableRowStyle;
import io.bretty.console.table.Alignment;
import io.bretty.console.table.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			choice = view.getMainMenuChoice();
			if (choice == 1) {
				serviceMain.handleLogin();
			} else if (choice == 2) {
				serviceMain.handleCreateAccount();
			} else if (choice == 3) {
				serviceMain.handleWithOutLogin();
			}
		} while (choice != 0);
	}
}
