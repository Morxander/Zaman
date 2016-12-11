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
        Log.v("current", "Current : " + getCurrentTimeStamp());
        Log.v("current", "Given : " + timetamp);
        Log.v("current", "Diff : " + diff);
        diffToString(diff);
    }

    public static long getCurrentTimeStamp() {
        return new Date().getTime() / 1000;
    }

    public String getTime() {
        return time;
    }

    private void getTimeString(long diff, int unit, String one_thing, String many_things) {
        if (diff < 0) {
            diff = Math.abs(diff);
            if (diff < 2 * unit) {
                //TODO support words like tomorrow, next week, next month, ...etc
                time = AngoTimeString.IN + "1 " + one_thing;
            } else {
                int number_of_things = Math.round((diff / unit));
                time = AngoTimeString.IN + " " + String.valueOf(number_of_things) + " " + many_things;
            }
        } else {
            //TODO support words like yesterday, last week, last month, ...etc
            if (diff < 2 * unit) {
                time = "1 " + one_thing + " " + AngoTimeString.AGO;
            } else {
                int number_of_things = Math.round((diff / unit));
                time = String.valueOf(number_of_things) + " " + many_things + " " + AngoTimeString.AGO;
            }
        }
    }

    private void diffToString(long diff) {
        int minute = 60;
        int hour = 3600;
        int day = 86400;
        int week = 604800;
        int month = 2592000;
        int year = 31104000;
        long abs_diff = Math.abs(diff);
        if (abs_diff < minute) {
            //NOW
            time = AngoTimeString.NOW;
        } else if (abs_diff < hour) {
            //MINS
            getTimeString(diff, minute, AngoTimeString.MINUTE, AngoTimeString.MINUTES);
        } else if (abs_diff < day) {
            //HOURS
            getTimeString(diff, hour, AngoTimeString.HOUR, AngoTimeString.HOURS);
        } else if (abs_diff < week) {
            //DAYS
            getTimeString(diff, day, AngoTimeString.DAY, AngoTimeString.DAYS);
        } else if (abs_diff < month) {
            //WEEKS
            getTimeString(diff, week, AngoTimeString.WEEK, AngoTimeString.WEEKS);
        } else if (abs_diff < year) {
            //MONTHS
            getTimeString(diff, month, AngoTimeString.MONTH, AngoTimeString.MONTHS);
        } else {
            //YEARS
            getTimeString(diff, year, AngoTimeString.YEAR, AngoTimeString.YEARS);
        }
    }
}
