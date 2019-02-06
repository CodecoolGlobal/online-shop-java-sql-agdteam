package View;

import java.util.List;

import java.util.Collections;
import java.util.List;

public class View {
    private ValidatorInput validatorInput;

    public View(){
        this.validatorInput = new ValidatorInput();
    }

    private void showMenuFromTitleList(String menuTitle, List<String> menuOptions){
        System.out.println(menuTitle);
        for (int i = 0; i < menuOptions.size();i++){
            int optionNumber = i+1;
            System.out.println(optionNumber + ". " + menuOptions.get(i));
        }
    }

    public int getUserMenuChoice(String menuTitle, List<String> menuOptions){
        showMenuFromTitleList(menuTitle, menuOptions);
        System.out.println("Please select menu option:");
        return validatorInput.getIntInput(1, menuOptions.size());
    }


	public void printString(String string) {

	}

	public void printTable(Collections collections, List listHeaders) {

	}

}
