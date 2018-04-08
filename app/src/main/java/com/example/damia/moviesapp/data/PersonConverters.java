package com.example.damia.moviesapp.data;

import android.arch.persistence.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by damia on 27.03.2018.
 */

public class PersonConverters {

    @TypeConverter
    public static GregorianCalendar fromString(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        Date date;
        try{
            date = sdf.parse(data);
        }catch(Exception e){
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    @TypeConverter
    public static String dateToString(GregorianCalendar calendar){
        if(calendar == null) return null;
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
            return sdf.format(calendar.getTime());
        }
    }
}
