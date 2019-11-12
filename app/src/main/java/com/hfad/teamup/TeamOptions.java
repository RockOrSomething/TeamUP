package com.hfad.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_options);
    }

    public void launchMain(View view){
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }

}
