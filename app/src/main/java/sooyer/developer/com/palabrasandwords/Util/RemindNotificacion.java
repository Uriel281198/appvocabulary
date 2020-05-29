package sooyer.developer.com.palabrasandwords.Util;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import sooyer.developer.com.palabrasandwords.Activities.HomeActivity;
import sooyer.developer.com.palabrasandwords.R;

public class RemindNotificacion extends BroadcastReceiver {

    String nombre ;
    String tras ;

    public RemindNotificacion(String nombre, String tras) {
        this.nombre = nombre;
        this.tras = tras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTras() {
        return tras;
    }

    public void setTras(String tras) {
        this.tras = tras;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Toast.makeText(context, ""+bundle.getString("name"), Toast.LENGTH_SHORT).show();

        Intent resultIntent = new Intent(context, HomeActivity.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify")
                .setSmallIcon(R.drawable.view)
                .setContentTitle("Yes it can")
                .setContentText("Hey")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(200,builder.build());
    }


}
