package com.example.ibrokhimov.draft_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class historicalp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicalp);
    }
    public void goToMap(View view) {
        Intent showMap_intent = new Intent(this,MapsActivity .class);
        historicalp.this.startActivity(showMap_intent);
    }
    public void back(View view) {
        Intent showMap_intent = new Intent(this,Menu.class);
        startActivity(showMap_intent);
    }
}
