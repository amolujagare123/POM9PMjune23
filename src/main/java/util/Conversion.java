package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry)
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN":
                convertedCountry = "India";
                break;
            case "US":
                convertedCountry = "United States";
                break;
            case "GB":
                convertedCountry = "United Kingdom";
                break;
            case "FR":
                convertedCountry = "France";
                break;
            case "DE":
                convertedCountry = "Germany";
                break;
            case "JP":
                convertedCountry = "Japan";
                break;
            case "AU":
                convertedCountry = "Australia";
                break;
            case "BR":
                convertedCountry = "Brazil";
                break;
            case "CN":
                convertedCountry = "China";
                break;
            case "RU":
                convertedCountry = "Russia";
        }

        return convertedCountry;
    }
    public static String convertGender(String genderID)
    {
        String gender="";

        switch (genderID)
        {
            case "0" : gender ="Male"; break;
            case "1" : gender ="Female"; break;
            case "2" : gender ="Other"; break;
        }

        return gender;
    }


    public static  String convertDate(String dbDate) throws ParseException//1989-05-08
    {
        //yyyy-dd-MM
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);
   // converting in the format dd/MM/yyyy -->  08/05/1989

        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
