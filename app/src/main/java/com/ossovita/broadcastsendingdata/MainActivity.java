package com.ossovita.broadcastsendingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View v){
        Intent intent = new Intent(this,BroadcastInner.class);
        Bundle bundle = new Bundle();
        bundle.putString("name","Ayşe");
        bundle.putInt("age",22);
        bundle.putString("job","Psychiatrist");
        //bundle'a verileri koyduk ve direkt bundle'ı gönderdik
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    public static class BroadcastInner extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //intent.getExtras direkt olarak o intent ile gönderilen bundle'ı getirir
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            int age = bundle.getInt("age");
            String job = bundle.getString("job");
            Toast.makeText(context, name+ ", " +age + ", " +job, Toast.LENGTH_SHORT).show();


        }
    }
}