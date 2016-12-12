package morxander.zaman;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by morxander on 12/11/16.
 */

public class ZamanTextView extends TextView {

    long timestamp;
    TimeWatcher timeWatcher = TimeWatcher.getInstance();
    private ZamanUtil zamanUtil;

    public ZamanTextView(Context context) {
        super(context);
    }

    public ZamanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZamanTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ZamanTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTimeStamp(long timestamp) {
        this.timestamp = timestamp;
        zamanUtil = new ZamanUtil(timestamp);
        setText(zamanUtil.getTime());
        timeWatcher.attach(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        timeWatcher.detached(this);
    }

    public void update() {
        zamanUtil.calculateTime(timestamp);
        setText(zamanUtil.getTime());
    }

    public long getTimestamp() {
        return timestamp;
    }
}
