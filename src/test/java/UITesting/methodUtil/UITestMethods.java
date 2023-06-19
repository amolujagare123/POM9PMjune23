package UITesting.methodUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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

    public static boolean checkEnability(WebElement element)
    {
        boolean actual = false;
        try {
            actual = element.isEnabled();
        } catch (Exception e) {

        }
        return actual;
    }

    public static String spellCheck(WebElement element)
    {
        String actual="";
        try {
            actual = element.getText();
        } catch (Exception e) {

        }
        return actual;
    }

    public static String getElementAttributeValue(WebElement element,String attribute)
    {
        String value="";
        try {
            value = element.getAttribute(attribute);
        } catch (Exception e) {

        }
        return value;
    }

    public static String getElementCssValue(WebElement element,String css)
    {
        String value="";
        try {
            value = element.getCssValue(css);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getElementColor(WebElement element,String colorCSS)
    {
        String rawColor = getElementCssValue(element,colorCSS);

        return  Color.fromString(rawColor).asHex().toUpperCase();
    }



}
