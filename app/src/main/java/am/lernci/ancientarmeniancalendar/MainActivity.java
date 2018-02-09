package am.lernci.ancientarmeniancalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final Tomar TOMAR = new Tomar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.appactivity_hour)).setText(TOMAR.getHourName());
        ((TextView) findViewById(R.id.appactivity_date)).setText(TOMAR.getDateName());

        final NumberPicker hourPicker = findViewById(R.id.appactivity_hour_picker);
        hourPicker.setMinValue(1);
        hourPicker.setMaxValue(24);
        hourPicker.setDisplayedValues(CalendarNames.HOUR_NAMES);
        hourPicker.setValue(TOMAR.getHour());

        final NumberPicker weekPicker = findViewById(R.id.appactivity_week_picker);
        weekPicker.setMinValue(1);
        weekPicker.setMaxValue(7);
        weekPicker.setDisplayedValues(CalendarNames.WEEK_NAMES);
        weekPicker.setValue(TOMAR.getDayOfWeek());

        final NumberPicker dayPicker = findViewById(R.id.appactivity_day_picker);
        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(30);
        dayPicker.setDisplayedValues(CalendarNames.DAY_NAMES);
        dayPicker.setValue(TOMAR.getDayOfMonth());

        final NumberPicker monthPicker = findViewById(R.id.appactivity_month_picker);
        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(13);
        monthPicker.setDisplayedValues(CalendarNames.MONTH_NAMES);
        monthPicker.setValue(TOMAR.getMonth());
    }
}
