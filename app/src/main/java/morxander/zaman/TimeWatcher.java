package morxander.zaman;

import android.os.Handler;

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
    private static List<ZamanTextView> textViews = new ArrayList<ZamanTextView>();
    private static Timer timer;
    private static TimerTask timerTask;

    private TimeWatcher() {
    }

    public static TimeWatcher getInstance() {
        if (timeWatcher == null) {
            timeWatcher = new TimeWatcher();
            timer = new Timer();
            initializeTimerTask();
            timer.schedule(timerTask, 1000, 1000);
        }
        return timeWatcher;
    }

    public static void updateTextViews() {
        for (ZamanTextView textView : textViews) {
            textView.update();
        }
    }

    public static void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        updateTextViews();
                    }
                });
            }
        };
    }

    public void attach(ZamanTextView textView) {
        if (!textViews.contains(textView)) {
            textViews.add(textView);
        }
    }

    public void detached(ZamanTextView textView) {
        if (textViews.contains(textView)) textViews.remove(textView);
    }


}
