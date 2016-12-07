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

    public static long getCurrentTimeStamp(){
        return new Date().getTime() / 1000;
    }

    public String getTime() {
        return time;
    }

    private void diffToString(long diff){
        if(diff < 59 && diff >= 0){
            time = AngoTimeString.NOW;
        }else if(diff < 120 && diff >= 60){
            time = AngoTimeString.ONE_MINUTE;
        }else if(diff < 3600 && diff >= 60){
            int mins = Math.round((diff / 60));
            time = String.valueOf(mins) + " " + AngoTimeString.MINUTES + " " + AngoTimeString.AGO;
        }else {
            time = "UNKNOWN";
        }
    }
}
