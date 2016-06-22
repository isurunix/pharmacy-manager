/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.etc;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author isuru
 */
public class Validate {
    
    public static boolean validateTelephone(String tel){
        String regex;
        regex = "^(0[1-9][1-9]\\d{7})*$";
        Pattern patterrn = Pattern.compile(regex);
        Matcher matcher = patterrn.matcher(tel);
        return matcher.matches();
    }
    
    public static boolean validateDecimal(String dec){
        String regex = "^([1-9][0-9]+.[0-9]{2,4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dec);
        return matcher.matches();
    }
    
    public static boolean validateInt(String integer){
        String regex = "^([1-9][0-9]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(integer);
        return matcher.matches();
    }
    
    public static void main(String args[]){
        System.out.println(validateDecimal("600.00"));
    }
    
}
