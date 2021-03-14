package com.dispatch.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public   class DateFormatter {

    public final static String dateFormat="yyyy-MM-dd";
    public final static String dateAndTimeFormat="yyy-MM-dd hh:mm:ss aa";

    public  static  String formatDate(Date date) {
        //Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : " + strDate);
return strDate;
    }

    public static  String formatDateAndTime(Date date) {
       // Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateAndTimeFormat);
        String  strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : " + strDate);
return strDate;
    }

    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }

 /*   public static void main(String[] args) throws ParseException {


SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Date date1 = sdf.parse("2021-03-07");
    Date date2 = sdf.parse("2021-03-12");
    Date date3 = sdf.parse("2021-03-06");
    boolean flag = isDateInBetweenIncludingEndPoints(date1,date2,date3);
        System.out.println(flag);

    }*/
    }
