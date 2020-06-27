package sooyer.developer.com.palabrasandwords.Activities;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import sooyer.developer.com.palabrasandwords.R;
import sooyer.developer.com.palabrasandwords.Util.RemindNotificacion;

public class MainActivity extends AppCompatActivity {
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificactionChannel();

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 31   );
        calendar.set(Calendar.SECOND, 0   );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);

       findViewById(R.id.notificacion).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(MainActivity.this, "Send", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(MainActivity.this, RemindNotificacion.class);
               PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
               AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

               alarmManager.setExact(
                       AlarmManager.RTC_WAKEUP
                        ,calendar.getTimeInMillis(),
                       pendingIntent
               );

           }
       });
    }

    public Calendar setca (){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 30    );
        calendar.set(Calendar.SECOND, 0    );

        return calendar;
    }

    public void createNotificactionChannel (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Other Notificacion";
            String description ="asdsadas";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notify",name,importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

}