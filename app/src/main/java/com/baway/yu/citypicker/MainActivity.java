package com.baway.yu.citypicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.city_picker.CityListActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.id_tv_city_name);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityListActivity.startCityActivityForResult(MainActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CityListActivity.REQUEST_CODE&&resultCode==CityListActivity.RESULT_CODE){
            String city= data.getStringExtra(CityListActivity.RESULT_KEY);
            tv.setText(city);
        }
    }
}
