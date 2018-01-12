package am.lernci.ancientarmeniancalendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                for (int appWidgetId : appWidgetIds) {
                    updateAppWidget(context, appWidgetManager, appWidgetId);
                }
            }
        }, 5000, 5000);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}
