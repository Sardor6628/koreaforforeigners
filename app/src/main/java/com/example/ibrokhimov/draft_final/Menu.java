package com.example.ibrokhimov.draft_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button culture, food, historicalplace, place, shoping, contactus, exit,weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        culture=(Button)findViewById(R.id.culture);
        food=(Button)findViewById(R.id.food);
        historicalplace=(Button)findViewById(R.id.history);
        shoping=(Button)findViewById(R.id.shoping);
        contactus=(Button)findViewById(R.id.contactus) ;
        weather=(Button)findViewById(R.id.weather);
        exit=(Button)findViewById(R.id.exit);}

    public void changeAct(View view) {
        Intent bt;
        switch (view.getId()){
            case R.id.culture:
                bt = new Intent(this, culture.class);;
                startActivity(bt);break;
            case R.id.history:
                bt = new Intent(this, historicalp.class);;
                startActivity(bt);break;
            case R.id.food:
                bt = new Intent(this, food.class);;
                startActivity(bt);break;
            case R.id.shoping:
                bt = new Intent(this, MainActivity.class);;
                startActivity(bt);break;
            case R.id.exit:
                this.finish();break;
            case R.id.weather:
                bt = new Intent(this, Weather_00.class);;
                startActivity(bt);break;
            case R.id. contactus:
                bt = new Intent(this, contactUS.class);;
                startActivity(bt);break;


            default:break;

        }

    }



}
