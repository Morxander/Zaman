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
            if(diff < 2*minute) {
                time = AngoTimeString.ONE_MINUTE;
            }else{
                int mins = Math.round((diff / minute));
                time = String.valueOf(mins) + " " + AngoTimeString.MINUTES + " " + AngoTimeString.AGO;
            }
        }else if(diff < day){
            //HOURS
            if(diff < 2*hour) {
                time = AngoTimeString.ONE_HOUR;
            }else{
                int hrs = Math.round((diff / hour));
                time = String.valueOf(hrs) + " " + AngoTimeString.HOURS + " " + AngoTimeString.AGO;
            }
        }else if(diff < week){
            //DAYS
            if(diff < 2*day) {
                time = AngoTimeString.ONE_DAY;
            }else{
                int days = Math.round((diff / day));
                time = String.valueOf(days) + " " + AngoTimeString.DAYS + " " + AngoTimeString.AGO;
            }
        }else if(diff < month){
            //WEEKS
            if(diff < 2*week) {
                time = AngoTimeString.ONE_WEEK;
            }else{
                int weeks = Math.round((diff / week));
                time = String.valueOf(weeks) + " " + AngoTimeString.WEEKS + " " + AngoTimeString.AGO;
            }
        }else if(diff < year){
            //MONTHS
            if(diff < 2*month) {
                time = AngoTimeString.ONE_MONTH;
            }else{
                int months = Math.round((diff / month));
                time = String.valueOf(months) + " " + AngoTimeString.MONTHS + " " + AngoTimeString.AGO;
            }
        }else{
            //YEARS
            if(diff < 2*year) {
                time = AngoTimeString.ONE_YEAR;
            }else{
                int years = Math.round((diff / year));
                time = String.valueOf(years) + " " + AngoTimeString.YEARS + " " + AngoTimeString.AGO;
            }
        }
    }
}
