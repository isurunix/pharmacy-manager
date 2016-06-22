/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.etc;

import java.text.NumberFormat;
import vidulaPharma.IdType;

/**
 *
 * @author isuru
 */
public class IdGen {
    
    
    public static String getId(String id){
         String num = id.substring(1);
         String character = id.substring(0, 1);
         
         int parseNum = Integer.parseInt(num);
         parseNum++;
         NumberFormat format = NumberFormat.getNumberInstance();
         format.setMinimumIntegerDigits(3);
         String formatedNum = format.format(parseNum);
         
         return character+formatedNum;
    }
}
