import Service.*;


public class Controller {
	private ServiceMain serviceMain;

	public Controller(){
		this.serviceMain = new ServiceMain();
	}

	public void mainLoop() {
		while (serviceMain.handleLogin());
	}
}
