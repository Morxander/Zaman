package morxander.zaman;

import android.util.Log;

import java.util.Date;
import java.util.HashMap;


/**
 * Created by morxander on 12/6/16.
 */

public class ZamanUtil {

    public static final HashMap<String, Integer> units;

    static {
        units = new HashMap<String, Integer>();
        units.put("minute", 60);
        units.put("hour", 3600);
        units.put("day", 86400);
        units.put("week", 604800);
        units.put("month", 2592000);
        units.put("year", 31104000);

    }

    String time;

    public ZamanUtil(long timeStamp) {
        this.calculateTime(timeStamp);
    }

    public static long getCurrentTimeStamp() {
        return new Date().getTime() / 1000;
    }

    public void calculateTime(long timeStamp) {
        long diff = getCurrentTimeStamp() - timeStamp;
        Log.v("current", "Current : " + getCurrentTimeStamp());
        Log.v("current", "Given : " + timeStamp);
        Log.v("current", "Diff : " + diff);
        diffToString(diff);
    }

    public String getTime() {
        return time;
    }


    private void getTimeString(long diff, String one_unit, String one_thing, String many_things) {
        int unit = units.get(one_unit);
        if (diff < 0) {
            //FUTURE
            diff = Math.abs(diff);
            if (diff < 2 * unit) {
                time = ZamanTimeString.IN_ONE_THING.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = ZamanTimeString.IN + " " + String.valueOf(number_of_things) + " " + many_things;
            }
        } else {
            //PAST
            if (diff < 2 * unit) {
                time = ZamanTimeString.ONE_THING_AGO.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = String.valueOf(number_of_things) + " " + many_things + " " + ZamanTimeString.AGO;
            }
        }
    }

    private void diffToString(long diff) {
        long abs_diff = Math.abs(diff);
        if (abs_diff < units.get("minute")) {
            //NOW
            if(diff < 0){
                time = ZamanTimeString.IN_FEW_SECONDS;
            }else{
                time = ZamanTimeString.NOW;
            }
        } else if (abs_diff < units.get("hour")) {
            //MINS
            getTimeString(diff, "minute", ZamanTimeString.MINUTE, ZamanTimeString.MINUTES);
        } else if (abs_diff < units.get("day")) {
            //HOURS
            getTimeString(diff, "hour", ZamanTimeString.HOUR, ZamanTimeString.HOURS);
        } else if (abs_diff < units.get("week")) {
            //DAYS
            getTimeString(diff, "day", ZamanTimeString.DAY, ZamanTimeString.DAYS);
        } else if (abs_diff < units.get("month")) {
            //WEEKS
            getTimeString(diff, "week", ZamanTimeString.WEEK, ZamanTimeString.WEEKS);
        } else if (abs_diff < units.get("year")) {
            //MONTHS
            getTimeString(diff, "month", ZamanTimeString.MONTH, ZamanTimeString.MONTHS);
        } else {
            //YEARS
            getTimeString(diff, "year", ZamanTimeString.YEAR, ZamanTimeString.YEARS);
        }
    }
}
