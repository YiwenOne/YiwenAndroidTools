package com.example.yyiwen.fastmaildemo.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;

/**
 * Created by y.yiwen on 11/8/2016.
 */
public class LifefromDetectedBroadcastReceiver extends BroadcastReceiver{
    public static final String BURN="com.paad.alien.action.BURN_IT_FIRE";
    @Override
    public void onReceive(Context context, Intent intent) {
        //从Intent获得lifeform细节
        Uri data=intent.getData();
        String type=intent.getStringExtra("type");
        double lat=intent.getDoubleExtra("latitude",0);
        double lng=intent.getDoubleExtra("longitude",0);
        Location loc=new Location("gps");
        loc.setLatitude(lat);
        loc.setLongitude(lng);
        if(type.equals("alien")){
            Intent startIntent=new Intent(BURN,data);
            startIntent.putExtra("latitude",lat);
            startIntent.putExtra("longitude",lng);
            context.startActivity(startIntent);
        }
    }
}
