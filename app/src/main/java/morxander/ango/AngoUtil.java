package morxander.ango;

import android.util.Log;

import java.util.Date;

/**
 * Created by morxander on 12/6/16.
 */

public class AngoUtil {

    String time;

    public AngoUtil(long timetamp) {
        long diff = getCurrentTimeStamp() - timetamp;
        Log.v("current","Current : " + getCurrentTimeStamp());
        Log.v("current","Given : " + timetamp);
        Log.v("current","Diff : " + diff);
        diffToString(diff);
    }

    public static long getCurrentTimeStamp(){return new Date().getTime() / 1000;}

    public String getTime() {
        return time;
    }

    private void getTimeString(long diff, int unit, String one_thing, String many_things){
        if(diff < 2*unit) {
            time = one_thing;
        }else{
            int number_of_things = Math.round((diff / unit));
            time = String.valueOf(number_of_things) + " " + many_things + " " + AngoTimeString.AGO;
        }
    }
    private void diffToString(long diff){
        int minute = 60;
        int hour = 3600;
        int day = 86400;
        int week = 604800;
        int month = 2592000;
        int year = 31104000;
        if(diff < minute){
            //NOW
            time = AngoTimeString.NOW;
        }else if(diff < hour){
            //MINS
            getTimeString(diff, minute, AngoTimeString.ONE_MINUTE, AngoTimeString.MINUTES) ;
        }else if(diff < day){
            //HOURS
            getTimeString(diff, hour, AngoTimeString.ONE_HOUR, AngoTimeString.HOURS) ;
        }else if(diff < week){
            //DAYS
            getTimeString(diff, day, AngoTimeString.ONE_DAY, AngoTimeString.DAYS) ;
        }else if(diff < month){
            //WEEKS
            getTimeString(diff, week, AngoTimeString.ONE_WEEK, AngoTimeString.WEEKS) ;
        }else if(diff < year){
            //MONTHS
            getTimeString(diff, month, AngoTimeString.ONE_MONTH, AngoTimeString.MONTHS) ;
        }else{
            //YEARS
            getTimeString(diff, year, AngoTimeString.ONE_YEAR, AngoTimeString.YEARS);
        }
    }
}
