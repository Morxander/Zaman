package morxander.ango;

import android.util.Log;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.Timer;


/**
 * Created by morxander on 12/6/16.
 */

public class AngoUtil {

    String time;
    public static final HashMap<String, Integer> units;
    static{
        units = new HashMap<String, Integer>();
        units.put("minute", 60);
        units.put("hour"  , 3600);
        units.put("day"   , 86400);
        units.put("week"  , 604800);
        units.put("month" , 2592000);
        units.put("year"  , 31104000);

    }
    public AngoUtil(long timeStamp) {
        this.calculateTime(timeStamp);
        this.startTimer(timeStamp);
    }
    public void calculateTime(long timeStamp){
        long diff = getCurrentTimeStamp() - timeStamp;
        Log.v("current", "Current : " + getCurrentTimeStamp());
        Log.v("current", "Given : " + timeStamp);
        Log.v("current", "Diff : " + diff);
        diffToString(diff);
    }

    public static long getCurrentTimeStamp() {
        return new Date().getTime() / 1000;
    }

    public String getTime() {
        return time;
    }
    public void startTimer(long timestamp){
        TimerTask tt = new TimerTask() {
            private long ts;
            private AngoUtil that;
            @Override
            public void run() {
                System.out.println("In Timer Task");
                this.that.calculateTime(this.ts);
            }
            public TimerTask TimerTask(long ts, AngoUtil that){
                this.ts = ts;
                this.that = that;
                return this;
            }
        }.TimerTask(timestamp, this);
        Timer t = new Timer();
        t.scheduleAtFixedRate(tt, 0, 60*1000);
        //TODO two way binding to the text view
    }

    private void getTimeString(long diff, String one_unit, String one_thing, String many_things) {
        int unit = units.get(one_unit);
        if (diff < 0) {
            //FUTURE
            diff = Math.abs(diff);
            if (diff < 2 * unit) {
                time = AngoTimeString.IN_ONE_THING.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = AngoTimeString.IN + " " + String.valueOf(number_of_things) + " " + many_things;
            }
        } else {
            //PAST
            if (diff < 2 * unit) {
                time = AngoTimeString.ONE_THING_AGO.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = String.valueOf(number_of_things) + " " + many_things + " " + AngoTimeString.AGO;
            }
        }
    }

    private void diffToString(long diff) {
        long abs_diff = Math.abs(diff);
        if (abs_diff < units.get("minute") ) {
            //NOW
            time = AngoTimeString.NOW;
        } else if (abs_diff < units.get("hour")) {
            //MINS
            getTimeString(diff, "minute", AngoTimeString.MINUTE, AngoTimeString.MINUTES);
        } else if (abs_diff < units.get("day")) {
            //HOURS
            getTimeString(diff, "hour", AngoTimeString.HOUR, AngoTimeString.HOURS);
        } else if (abs_diff < units.get("week")) {
            //DAYS
            getTimeString(diff, "day", AngoTimeString.DAY, AngoTimeString.DAYS);
        } else if (abs_diff < units.get("month")) {
            //WEEKS
            getTimeString(diff, "week", AngoTimeString.WEEK, AngoTimeString.WEEKS);
        } else if (abs_diff < units.get("year")) {
            //MONTHS
            getTimeString(diff, "month", AngoTimeString.MONTH, AngoTimeString.MONTHS);
        } else {
            //YEARS
            getTimeString(diff, "year", AngoTimeString.YEAR, AngoTimeString.YEARS);
        }
    }
}
