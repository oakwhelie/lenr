package larn.lrn.lenr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity
{
    public static final String package_prefix = Main.class.getCanonicalName();
    public static final String package_prefix_imgwidth = package_prefix + ".Width";
    public static final String package_prefix_imgheight = package_prefix + "Height";
    private static final String tag = "activities_Main:";
    private Broadcast broadcast = new Broadcast();
    public static final String APP_IN_BACKGROUND = "app now run in background";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(tag, "onCreate()");

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(APP_IN_BACKGROUND);
        registerReceiver(broadcast, filter);

        final Button getImgButon = findViewById(R.id.imgButton);
        getImgButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "Button getImgButton");
                getImgData();
            }
        });
        final Button dothings = findViewById(R.id.dothings);
        dothings.setOnClickListener(new View.OnClickListener() {
           @Override
           public  void onClick(View v){
               Log.d(tag, "Button dothings");
               Intent todothings = new Intent(Main.this, DoThings.class);

               ImageView img = findViewById(R.id.img);
               todothings.putExtra(package_prefix_imgwidth, img.getWidth());
               todothings.putExtra(package_prefix_imgheight, img.getHeight());
               //todothings.putExtra(package_prefix_imgheight, img.getHeight());

               startActivity(todothings);
            }
        });
    }

    public void toNotification(View v)
    {
        startActivity(new Intent(this, Notification.class));
    }

    public void goService(View view)
    {
        Log.d(tag, "goService()");
        Intent togoservice = new Intent(Main.this, ServiceAc.class);
        startActivity(togoservice);
    }

    @Override
    public void onBackPressed()
    {
        Log.d(tag, "onBackPressed()");
        Intent fin = new Intent(Intent.ACTION_MAIN);
        fin.addCategory(Intent.CATEGORY_HOME);
        fin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(fin);

        sendBroadcast(new Intent(APP_IN_BACKGROUND));

        /*keep main activities (app run in background)
        Intent fin = new Intent(Intent.ACTION_MAIN);
        fin.addCategory(Intent.CATEGORY_HOME);
        fin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(fin);
        */
        //finish(); //total quit
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
        super.onDestroy();
    }
    @Override
    protected void onRestart()
    {
        Log.d(tag, "onRestart()");
        super.onRestart();
    }

    public void getImgData()
    {
        Log.d(tag, "getImgData()");
        ImageView img = findViewById(R.id.img);

        TextView width = findViewById(R.id.width);
        width.setText(String.valueOf(img.getWidth()));

        TextView height = findViewById(R.id.height);
        height.setText(String.valueOf(img.getHeight()));
    }
}
