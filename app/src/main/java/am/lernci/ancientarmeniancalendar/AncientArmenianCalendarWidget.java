package am.lernci.ancientarmeniancalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class AncientArmenianCalendarWidget extends AppWidgetProvider {

    static void updateAppWidget(final Context context, final AppWidgetManager appWidgetManager, final int appWidgetId) {
        final Tomar tomar = new Tomar();

        final CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ancient_armenian_calendar_widget);

        views.setTextViewText(R.id.appwidget_hour, tomar.getHourName());
        views.setTextViewText(R.id.appwidget_date, tomar.getDateName());

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(final Context context) {
        super.onEnabled(context);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 3 seconds
        if (am != null) {
            am.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 100 * 3,
                    1000,
                    pi
            );
        }
        // face = Typeface.createFromAsset(context.getAssets(), "fonts/arm_bernhardd.ttf");
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(final Context context) {
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {

            am.cancel(sender);
        }
        super.onDisabled(context);
    }
}
