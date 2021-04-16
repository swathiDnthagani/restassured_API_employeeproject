package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    public static String empName(){
        String generatedName= RandomStringUtils.randomAlphabetic(6);
        return (generatedName);
    }
    public static String empSal(){
        String generatedSalary = RandomStringUtils.randomNumeric(5);
        return (generatedSalary);
    }
    public static String empAge(){
        String generatedAge= RandomStringUtils.randomNumeric(2);
        return (generatedAge);
    }
}
