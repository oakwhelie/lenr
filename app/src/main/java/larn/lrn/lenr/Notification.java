package larn.lrn.lenr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Notification extends AppCompatActivity
{
    private static final String PRIMARY_CHANNEL_ID = "chatto chatto";
    private NotificationManager notificationManager;
    private static final int NOTIFICATION_ID = 2323;
    private static int notid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel =
                    new NotificationChannel(PRIMARY_CHANNEL_ID, "First", NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.CYAN);
            channel.setDescription("notification bro");
        }
    }



    public void createNotficationChannel()
    {

    }

    public void sendNotification(View v)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setColor(Color.CYAN)
                .setContentTitle("waagghh")
                .setContentText("u got wagghh")
                .setSmallIcon(R.drawable.woah).setNumber(67);
        //notificationManager.notify(NOTIFICATION_ID, builder.build());
        notificationManager.notify(notid, builder.build());
        notid++;
    }
}
