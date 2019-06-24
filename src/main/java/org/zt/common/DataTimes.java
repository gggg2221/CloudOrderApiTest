package org.zt.common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DataTimes {

    public static String Dat(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtime=(df.format(new Date()));
        return dtime;
    }

    public static String Randoms(){
        String base = "1234567890abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer numb = new StringBuffer();
        for ( int i = 0; i < 32; i++ )
        {
                int number = random.nextInt( base.length() );
                numb.append( base.charAt( number ) );
        }
        return numb.toString();
        }

//        public static void main(String args[]){
//        for (int i=1;i<10;i++){
//            String s= Random();
//            System.out.println(s);
//        }

}
