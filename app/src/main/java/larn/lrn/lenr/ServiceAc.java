package larn.lrn.lenr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceAc extends AppCompatActivity
{
    private String tag = "activities_ServiceAc";
    private static boolean service_started;
    //private static boolean isStopped;
    private Button startservicebutton;
    private boolean timerstarted;
    private ClockCounter<ServiceAc>clockcounter;
    private Button timebutton;
    private Broadcast broadcast = new Broadcast();
    public static final String ASYNC_RUN = "Async is running";
    public  static final String ASYN_STOP = "Async is stopped";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceac);
        Log.d(tag, "onCreate()");

        startservicebutton = findViewById(R.id.doservice);
        timebutton = findViewById(R.id.checktime);
        timerstarted = false;
        //isStopped = false;
        IntentFilter filter = new IntentFilter();
        filter.addAction(ASYNC_RUN);
        filter.addAction(ASYN_STOP);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcast, filter);
    }
    @Override
    public void onBackPressed()
    {
        Log.d(tag, "onBackPressed()");
        super.onBackPressed();
    }
    @Override
    protected void onStart()
    {
        Log.d(tag, "onStart()");
        super.onStart();
    }
    @Override
    protected void onResume()
    {
        Log.d(tag, "onResume()");
        super.onResume();
    }
    @Override
    protected void onPause()
    {
        Log.d(tag, "onPause()");
        super.onPause();
    }
    @Override
    protected void onStop()
    {
        Log.d(tag, "onStop()");
        super.onStop();
    }
    @Override
    protected void onDestroy()
    {
        Log.d(tag, "onDestroy()");
        //isStopped = true;
        super.onDestroy();
    }
    public void doService(View view)
    {
        Log.d(tag, "doService()");
        if(!service_started) startService();
        else stopService();
    }
    public void startService()
    {
        Log.d(tag, "startService()");
        startService(new Intent(getBaseContext(), MyService.class));
        service_started = true;
        startservicebutton.setText(R.string.stop_service);

    }
    @Override
    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int flags)
    {
        Log.d(tag, "bindService()");
        return super.bindService(intent, serviceconnection, flags);
    }
    public void stopService()
    {
        Log.d(tag, "stopService()");
        stopService(new Intent(getBaseContext(), MyService.class));
        service_started = false;
        startservicebutton.setText(R.string.start_service);
    }

    public void checkTime(View view)
    {
        Log.d(tag, "checkTime()");
        if(!timerstarted)
        {
            clockcounter = new ClockCounter<>(this);
            clockcounter.execute(R.id.time);
            timerstarted = true;
            timebutton.setText(R.string.stop_check_time);
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ASYNC_RUN));
        }
        else
        {
            clockcounter.cancel(true);
            timerstarted = false;
            timebutton.setText(R.string.check_time);
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ASYN_STOP));
        }

        /*TimerOperation timeops = new TimerOperation(this);
        timeops.execute();*/

    }

    /*private static class TimerOperation extends AsyncTask<String, String, String>
    {
        private String time;
        private String tag = "activities_ServiceAc_TimerOperation";
        private WeakReference<ServiceAc> activity;//use this to access the activity to avoid leaks

        private TimerOperation(ServiceAc activity)
        {
            this.activity = new WeakReference<>(activity);
        }
        @Override
        protected void onPreExecute()
        {
            Log.d(tag, "onPreExecute()");
            time = null;
            isStopped = false;
        }
        @Override
        protected String doInBackground(String... string)
        {
            Log.d(tag, "doInBackground()");
            while(!isStopped)
            {
                time = new Time(System.currentTimeMillis()).toString();
                publishProgress(time);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            return time;
        }
        @Override
        protected void onProgressUpdate(String... values)
        {
            ServiceAc ser = activity.get();
            TextView timetext = ser.findViewById(R.id.time);
            timetext.setText(time);
        }
        @Override
        protected void onPostExecute(String result)
        {
            Log.d(tag, "onPostExecute()");
        }
    }*/
}

