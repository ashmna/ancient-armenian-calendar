package am.lernci.ancientarmeniancalendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

        ((TextView) findViewById(R.id.appactivity_text_date)).setText(DateFormat.format("yyyy-MM-dd", TOMAR.getCalendar().getTime()));
        ((TextView) findViewById(R.id.appactivity_text_time)).setText(DateFormat.format("hh:mm", TOMAR.getCalendar().getTime()));
    }

    public void refresh() {
        ((NumberPicker) findViewById(R.id.appactivity_hour_picker)).setValue(TOMAR.getHour());
        ((NumberPicker) findViewById(R.id.appactivity_week_picker)).setValue(TOMAR.getDayOfWeek());
        ((NumberPicker) findViewById(R.id.appactivity_day_picker)).setValue(TOMAR.getDayOfMonth());
        ((NumberPicker) findViewById(R.id.appactivity_month_picker)).setValue(TOMAR.getMonth());
        ((TextView) findViewById(R.id.appactivity_hour)).setText(TOMAR.getHourName());
        ((TextView) findViewById(R.id.appactivity_date)).setText(TOMAR.getDateName());
        ((TextView) findViewById(R.id.appactivity_text_date)).setText(DateFormat.format("yyyy-MM-dd", TOMAR.getCalendar().getTime()));
        ((TextView) findViewById(R.id.appactivity_text_time)).setText(DateFormat.format("hh:mm", TOMAR.getCalendar().getTime()));
    }

    public void handleSetToday(View v) {
        Calendar nowDate = Calendar.getInstance();
        Calendar calendar = TOMAR.getCalendar();
        calendar.set(
                nowDate.get(Calendar.YEAR),
                nowDate.get(Calendar.MONTH),
                nowDate.get(Calendar.DAY_OF_MONTH),
                nowDate.get(Calendar.HOUR_OF_DAY),
                nowDate.get(Calendar.MINUTE),
                nowDate.get(Calendar.SECOND)
        );

        this.refresh();
    }

    public void handleOpenTimePicker(View v) {
        Calendar calendar = TOMAR.getCalendar();
        TimePickerDialog  StartTime = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hour, int minute) {
                Calendar calendar = TOMAR.getCalendar();
                calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        hour,
                        minute
                );
                refresh();
            }
        },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );

        StartTime.show();
    }

    public void handleOpenDatePicker(View v) {
        Calendar calendar = TOMAR.getCalendar();
        DatePickerDialog  StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                TOMAR.getCalendar().set(year, monthOfYear, dayOfMonth);
                refresh();
            }
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        StartTime.show();
    }
}
