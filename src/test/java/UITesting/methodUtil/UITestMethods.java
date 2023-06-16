package UITesting.methodUtil;

import org.openqa.selenium.WebElement;

public class UITestMethods {

    public static boolean checkVisibility(WebElement element)
    {
        boolean actual = false;
        try {
            actual = element.isDisplayed();
        } catch (Exception e) {

        }
        return actual;
    }
}
