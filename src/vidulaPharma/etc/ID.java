package vidulaPharma.etc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package vidula.pharma.etc;

import java.text.NumberFormat;
//import vidula.pharma.IdType;

/**
 *
 * @author isuru
 */
public class ID {
    
    
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
    
    //public static void main(String[] args){
    //  System.out.println("OLD : "+args[0]+"\n"+"NEW : "+ID.getId(args[0]));
    //}
}
