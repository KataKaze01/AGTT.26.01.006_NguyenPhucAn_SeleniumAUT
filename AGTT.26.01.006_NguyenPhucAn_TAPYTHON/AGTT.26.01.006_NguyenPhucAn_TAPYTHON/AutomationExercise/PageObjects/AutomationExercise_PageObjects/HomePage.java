package AutomationExercise_PageObjects;

import Constant.Constant;

public class HomePage extends GeneralPage{
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.AUTOMATIONEXERCISE_URL);
        return this;
    }
}
