package morxander.ango;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by morxander on 12/12/16.
 */

public class TimeWatcher {

    private static final Handler handler = new Handler();
    private static TimeWatcher timeWatcher;
    private static List<AngoTextView> textViews = new ArrayList<AngoTextView>();
    private static Timer timer;
    private static TimerTask timerTask;

    private TimeWatcher() {
    }

    public static TimeWatcher getInstance() {
        if (timeWatcher == null) {
            timeWatcher = new TimeWatcher();
            timer = new Timer();
            initializeTimerTask();
        }
        return timeWatcher;
    }

    public void attach(AngoTextView textView) {
        textViews.add(textView);
        if (textViews.size() == 1) {
            timer.schedule(timerTask, 1000, 1000);
            Log.v("TimeWatcher", "TimeWatcher Started");
        }
    }

    public void detached(AngoTextView textView) {
        textViews.remove(textView);
        if (textViews.size() == 0) {
            stopWatcher();
            Log.v("TimeWatcher", "TimeWatcher Stopped");
        }
    }

    public static void updateTextViews() {
        for (AngoTextView textView : textViews) {
            textView.update();
        }
    }

    public void stopWatcher() {
        timerTask.cancel();
    }

    public static void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        updateTextViews();
                    }
                });
            }
        };
    }


}
