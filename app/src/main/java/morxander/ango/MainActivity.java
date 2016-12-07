package morxander.ango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AngoUtil angoUtil = new AngoUtil(1481106788);
        time = (TextView)findViewById(R.id.time);
        time.setText(angoUtil.getTime());
    }
}
