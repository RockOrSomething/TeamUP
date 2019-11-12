/**************************************************************************
*NOTE: The alarm clock function was written by Joe @ javapapers.com
* https://javapapers.com/android/android-alarm-clock-tutorial/
* It has been modified to work with this app's unique functionality, but credit is given where credit is due!
***************************************************************************/
package com.hfad.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class SetAlarm extends AppCompatActivity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static SetAlarm inst;
    private TextView alarmTextView;

    public static SetAlarm instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            Intent myIntent = new Intent(SetAlarm.this, SetAlarm.class);
            pendingIntent = PendingIntent.getBroadcast(SetAlarm.this, 0, myIntent, 0);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
            Log.d("MyActivity", "Alarm Off");
        }
    }

    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }

    public void launchMain(View view){
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }
}
