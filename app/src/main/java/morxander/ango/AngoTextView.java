package morxander.ango;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by morxander on 12/11/16.
 */

public class AngoTextView extends TextView {

    long timestamp;
    TimeWatcher timeWatcher = TimeWatcher.getInstance();
    private AngoUtil angoUtil;

    public AngoTextView(Context context) {
        super(context);
    }

    public AngoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AngoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AngoTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTimeStamp(long timestamp) {
        this.timestamp = timestamp;
        angoUtil = new AngoUtil(timestamp);
        setText(angoUtil.getTime());
        timeWatcher.attach(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        timeWatcher.detached(this);
    }

    public void update() {
        angoUtil.calculateTime(timestamp);
        setText(angoUtil.getTime());
    }

    public long getTimestamp() {
        return timestamp;
    }
}
