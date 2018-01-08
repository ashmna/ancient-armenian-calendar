package am.lernci.ancientarmeniancalendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class AncientArmenianCalendarWidget extends AppWidgetProvider {
    private static final Tomar TOMAR = new Tomar();

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ancient_armenian_calendar_widget);

        views.setTextViewText(R.id.appwidget_hour, TOMAR.getHourName());
        views.setTextViewText(R.id.appwidget_date, TOMAR.getDateName());

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // face = Typeface.createFromAsset(context.getAssets(), "fonts/arm_bernhardd.ttf");
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

