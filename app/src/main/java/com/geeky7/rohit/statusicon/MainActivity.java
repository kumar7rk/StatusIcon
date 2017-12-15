package com.geeky7.rohit.statusicon;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // code from - https://stackoverflow.com/a/44297936/2900127
        //shows the empty notification with an icon
        // and a icon in the status bar
        // remove the notification and remove the status icon
        // not required
        RemoteViews contentView = new RemoteViews(getPackageName(),
                R.layout.notification_layout);
        Context application = getApplicationContext();

        Intent resultIntent = new Intent(application, MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(application, 0, resultIntent, 0);
        NotificationManager nmgr = (NotificationManager) application.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(application)
                .setSmallIcon(android.R.drawable.btn_plus);

        mBuilder.setContent(contentView);
        Notification mNotification = mBuilder.build();

        //  mNotification.flags |= FLAG_NO_CLEAR;
        nmgr.notify(0, mNotification);    }
}
