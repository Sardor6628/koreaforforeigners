package com.example.ibrokhimov.draft_final;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class Weather extends AppCompatActivity {


    private double list2[]=new double[2];
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;

    Typeface weatherFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_weather  );
        Intent intent = getIntent();
        list2 = intent.getDoubleArrayExtra("List");

        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);



        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });

        asyncTask.execute(String.valueOf(list2[0]), String.valueOf(list2[1])); //  asyncTask.execute("Latitude", "Longitude")



    }


}