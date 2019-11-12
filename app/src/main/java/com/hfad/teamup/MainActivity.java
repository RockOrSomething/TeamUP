package com.hfad.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchAbout(View view){
        Intent myIntent = new Intent(getBaseContext(), About.class);
        startActivity(myIntent);
    }

    public void launchSetAlarm(View view){
        Intent myIntent = new Intent(getBaseContext(), SetAlarm.class);
        startActivity(myIntent);
    }

    public void launchTeamOptions(View view){
        Intent myIntent = new Intent(getBaseContext(), TeamOptions.class);
        startActivity(myIntent);
    }

    public void launchSettings(View view){
        Intent myIntent = new Intent(getBaseContext(), Settings.class);
        startActivity(myIntent);
    }

    public void launchTeamView(View view){
        Intent myIntent = new Intent(getBaseContext(), TeamView.class);
        startActivity(myIntent);
    }
}
