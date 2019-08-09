package com.example.ibrokhimov.draft_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Weather_00 extends AppCompatActivity {
Button seoul,busan,incheon,daegu,gwanju,suwon, daejon, ulsan, changwon, goyang, jeju,sejong;
public double []list=new double[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_00);
        seoul=(Button)findViewById(R.id.seoul);
        busan=(Button)findViewById(R.id.busan);
        incheon=(Button)findViewById(R.id.incheon);
        daegu=(Button)findViewById(R.id.daegu);
        gwanju=(Button)findViewById(R.id.gwangju);
        suwon=(Button)findViewById(R.id.suwon);
        daejon=(Button)findViewById(R.id.daejon);
        ulsan=(Button)findViewById(R.id.ulsan);
        changwon=(Button)findViewById(R.id.changwon);
        jeju=(Button)findViewById(R.id.jeju);
        goyang=(Button)findViewById(R.id.goyang);
        sejong=(Button)findViewById(R.id.sejong);


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.seoul:
                list[0]=37.566535;
                list[1]=126.977969;
                break;
            case R.id.busan:
                list[0]=35.179554;
                list[1]=129.075642;
                break;
            case R.id.incheon:
                list[0]=37.456256;
                list[1]=126.705206;
                break;
            case R.id.daegu:
                list[0]=35.871435;
                list[1]=128.601445;
                break;
            case R.id.gwangju:
                list[0]=35.159545;
                list[1]=126.852601;
                break;
            case R.id.suwon:
                list[0]=37.263573;
                list[1]=127.028601;
                break;
            case R.id.daejon:
                list[0]=36.350412;
                list[1]=127.384548;
                break;
            case R.id.ulsan:
                list[0]=35.538377;
                list[1]=129.311360;
                break;
            case R.id.changwon:
                list[0]=38.843239;
                list[1]=127.559707;
                break;
            case R.id.jeju:
                list[0]=33.499621;
                list[1]=126.531188;
                break;
                case R.id.goyang:
                list[0]=37.658360;
                list[1]=126.832020;
                break;
            case R.id.sejong:
                list[0]=36.631921;
                list[1]=127.329123;
                break;


                default:break;

        }
        Intent myIntent = new Intent(Weather_00.this, Weather.class);
        myIntent.putExtra("List", list);
        Weather_00.this.startActivity(myIntent);


    }
}
