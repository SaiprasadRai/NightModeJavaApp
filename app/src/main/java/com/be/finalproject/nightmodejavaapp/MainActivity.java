package com.be.finalproject.nightmodejavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Switch darkswitch;
    public AbsoluteSettingBean absoluteSettingBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        absoluteSettingBean = new AbsoluteSettingBean(this);

        if(absoluteSettingBean.loadNightModeState()==true) {
            setTheme(R.style.DarkAppTheme);
        }
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darkswitch=(Switch)findViewById(R.id.darkSwitch);
        if (absoluteSettingBean.loadNightModeState()==true) {
            darkswitch.setChecked(true);
        }
        darkswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    absoluteSettingBean.setNightModeState(true);
                    restartApp();
                }
                else {
                    absoluteSettingBean.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}