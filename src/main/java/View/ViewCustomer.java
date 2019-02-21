package View;

public class ViewCustomer extends View{

	public void showPleaseLoginMessage(){
		System.out.println("This option is available only for registered users. Please log in.");
		pause();
	}

	public String inputFeedbackMessage(){
		System.out.println("Please share your feedback about our shop");
		return validatorInput.inputFeedback();
	}

	public int getStarsRating() {
		System.out.println("Please rate our shop on 0-5 scale");
		return validatorInput.getIntInput(5);
	}

	public void showThanksForFeedbackMessage(){
		System.out.println("Thank you. Your feedback is well appreciated.");
	}
}
