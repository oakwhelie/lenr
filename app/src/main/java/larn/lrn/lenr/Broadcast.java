package larn.lrn.lenr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if(action != null)
        {
            switch (action)
            {
                case ServiceAc.ASYNC_RUN:
                    Toast.makeText(context, ServiceAc.ASYNC_RUN, Toast.LENGTH_SHORT).show(); break;
                case  ServiceAc.ASYN_STOP:
                    Toast.makeText(context, ServiceAc.ASYN_STOP, Toast.LENGTH_SHORT).show(); break;
                case Main.APP_IN_BACKGROUND:
                    Toast.makeText(context, Main.APP_IN_BACKGROUND, Toast.LENGTH_SHORT).show(); break;
                case Intent.ACTION_POWER_CONNECTED:
                    Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show(); break;
                case  Intent.ACTION_POWER_DISCONNECTED:
                    Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show(); break;
            }
        }
    }
}
