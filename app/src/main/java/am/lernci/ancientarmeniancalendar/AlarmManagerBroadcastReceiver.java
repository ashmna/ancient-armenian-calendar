package am.lernci.ancientarmeniancalendar;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        final Tomar tomar = new Tomar();

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ancient_armenian_calendar_widget);
        views.setTextViewText(R.id.appwidget_hour, tomar.getHourName());
        views.setTextViewText(R.id.appwidget_date, tomar.getDateName());


        ComponentName thisWidget = new ComponentName(context, AncientArmenianCalendarWidget.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thisWidget, views);
    }
}
