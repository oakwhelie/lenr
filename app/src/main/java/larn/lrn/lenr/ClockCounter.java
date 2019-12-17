package larn.lrn.lenr;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.sql.Time;

import androidx.appcompat.app.AppCompatActivity;

public class ClockCounter<T extends AppCompatActivity> extends AsyncTask <Integer, String, Void>
{
    private String tag = "Class_ClockCounter";
    private String time;
    private int id;
    private WeakReference<T>activity;

    public ClockCounter(T activity)
    {
        this.activity = new WeakReference<>(activity);
    }
    @Override
    protected void onPreExecute()
    {
        Log.d(tag, "onPreExecute()");
        time = null;
    }
    @Override
    protected Void doInBackground(Integer...id)
    {
        Log.d(tag, "doInBackground()");
        this.id = id[0];
        while (!activity.get().isDestroyed())
        {
            time = new Time(System.currentTimeMillis()).toString();
            publishProgress(time);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Log.d(tag, "interrupted");
                break;
            }
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(String...value)
    {
        Log.d(tag, "onProgressUpdate()");
        TextView timetext = activity.get().findViewById(id);
        timetext.setText(value[0]);
    }
    @Override
    protected void onPostExecute(Void result)
    {
        Log.d(tag, "onPostExecute()");
    }
}
