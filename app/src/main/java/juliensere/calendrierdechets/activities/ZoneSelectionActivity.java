package juliensere.calendrierdechets.activities;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

import juliensere.calendrierdechets.R;
import juliensere.calendrierdechets.alarms.AlarmReceiver;

public class ZoneSelectionActivity extends AppCompatActivity {

    private static int NOTIFICATION_TEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_zone_selection);
    }

    public void selectZone1(View view) {
        /*
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_my_calendar)
                .setContentTitle("My notification")
                .setContentText("Hello World!");


        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = mBuilder.build();
        mNotificationManager.notify(NOTIFICATION_TEST, notification);
        */

        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.setAction("juliensere.calendrierdechets.ACTION");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        //calendar.set(Calendar.HOUR, 20);
        //calendar.set(Calendar.MINUTE, 36);
        //calendar.set(Calendar.SECOND, 0);

        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 10);

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}
