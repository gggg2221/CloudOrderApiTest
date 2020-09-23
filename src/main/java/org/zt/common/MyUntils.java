package org.zt.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyUntils {


    public static String dat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtime = df.format(new Date());
        return dtime;
    }

    public static String outtime(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1=f.format(new Date());
        String[] tempStr = date1.split(":");
        Integer dd = Integer.parseInt(tempStr[1])+3;
        tempStr[1] = dd.toString();
//        System.out.println(tempStr[1]);
        String date2 = tempStr[0]+":"+tempStr[1]+":"+tempStr[2];
        return date2;
    }

    public static final String intime=dat();

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

    public static void getpath(){
        String basepath=System.getProperty("user.dir");
//        String testcasepath=basepath + "src"+"\"+"main"+"\"+"java"+"\"+testcase;

        System.out.println(basepath);

    }
//    public static void main(String[] args){
//       System.out.println(outtime());
//    }
}