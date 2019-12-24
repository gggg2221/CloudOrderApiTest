package org.zt.common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DataTimes {

    private DataTimes(){}

    public static String dat(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtime=(df.format(new Date()));
        return dtime;
    }

    public static String randoms(){
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
}
