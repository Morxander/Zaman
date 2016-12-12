package morxander.ango;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AngoTextView time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time2 = (AngoTextView)findViewById(R.id.time2);
        time2.setTimeStamp(1481543182);

    }
}
