package larn.lrn.lenr;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service
{
    String tag = "service_MyService";
    IBinder binder;
    boolean allowrebind;
    public MyService()
    {
        Log.d(tag, "MyService() ");
    }
    @Override
    public void onCreate()
    {
        Log.d(tag, "onCreate()");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startid)
    {
        Log.d(tag, "onStartCommand()");
        Toast.makeText(getBaseContext(), "service started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        Log.d(tag, "onBind()");
        return binder;

    }
    @Override
    public boolean onUnbind(Intent intent)
    {
        Log.d(tag, "onUnbind()");
        allowrebind = super.onUnbind(intent);
        return allowrebind;
    }
    @Override
    public void onRebind(Intent intent)
    {
        Log.d(tag, "onRebind()");
        super.onRebind(intent);
    }
    @Override
    public void onDestroy()
    {
        Log.d(tag, "onDestroy()");
        Toast.makeText(getBaseContext(), "service stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
