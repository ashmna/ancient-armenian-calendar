package am.lernci.ancientarmeniancalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final Tomar TOMAR = new Tomar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.appactivity_hour)).setText(TOMAR.getHourName());
        ((TextView) findViewById(R.id.appactivity_date)).setText(TOMAR.getDateName());
    }
}
