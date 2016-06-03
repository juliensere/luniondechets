package juliensere.calendrierdechets.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.sql.Time;
import java.util.logging.FileHandler;

/**
 * Created by JulienSere on 29/05/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    private final String RECEIVEALARM = "juliensere.calendrierdechets.RECEIVEALARM";

    @Override
    public void onReceive(Context context, Intent intent) {
        /*
        Time now = new Time(18, 00, 00);
        now.setToNow();
        String time = FileHandler.timeFormat(now);

        String action = intent.getAction();
        if (RECEIVEALARM.equals(action)) {
            // here you call a service etc.
        }
        */
    }
}
