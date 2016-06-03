package juliensere.calendrierdechets.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by JulienSere on 29/05/2016.
 */
public class BootIntentReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // get preferences
        // SharedPreferences preferences = context.getSharedPreferences("name_of_your_pref", 0);
        // Map<String, ?> scheduleData = preferences.getAll();

        // set the schedule time
        // if(scheduleData.containsKey("fromHour") && scheduleData.containsKey("toHour")) {
        //     int fromHour   = (Integer) scheduleData.get("fromHour");
        //     int fromMinute = (Integer) scheduleData.get("fromMinute");

        //     int toHour   = (Integer) scheduleData.get("toHour");
        //     int toMinute = (Integer) scheduleData.get("toMinute");

            //Do some action
        // }
    }

    private void setAlarm(Context context) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction("juliensere.calendrierdechets.ACTION");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        //calendar.set(Calendar.HOUR, 20);
        //calendar.set(Calendar.MINUTE, 36);
        //calendar.set(Calendar.SECOND, 0);

        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 10);
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}