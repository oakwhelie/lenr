package larn.lrn.lenr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DoThings extends AppCompatActivity
{
    String tag = "activities_DoThings";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.do_things);
        Log.d(tag, "onCreate()");

        Intent received = getIntent();

        TextView width = findViewById(R.id.width);
        width.setText(String.valueOf(received.getIntExtra(Main.package_prefix_imgwidth, 0)));

        TextView height = findViewById(R.id.height);
        height.setText(String.valueOf(received.getIntExtra(Main.package_prefix_imgheight, 0)));

        final Button goback = findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "Button goBack");
                DoThings.super.onBackPressed();
            }
        });
    }
    public void setText(View view)
    {
        Log.d(tag, "setText()");
        EditText fill = findViewById(R.id.editText);
        TextView text = findViewById(R.id.text);
        text.setText(fill.getText().toString());
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
        super.onDestroy();
    }
    @Override
    protected void onRestart()
    {
        Log.d(tag, "onRestart()");
        super.onRestart();
    }
}
