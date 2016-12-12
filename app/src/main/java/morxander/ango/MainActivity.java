package morxander.ango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView time;
    AngoTextView time2;
    Button hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  AngoUtil angoUtil = new AngoUtil(1481573503);
//
//        time = (TextView)findViewById(R.id.time);
//        time.setText(angoUtil.getTime());

        hide = (Button)findViewById(R.id.hide);

        time2 = (AngoTextView)findViewById(R.id.time2);
        time2.setTimeStamp(1481540049);



        final TimeWatcher timeWatcher = TimeWatcher.getInstance();
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeWatcher.detached(time2);
            }
        });
    }
}
