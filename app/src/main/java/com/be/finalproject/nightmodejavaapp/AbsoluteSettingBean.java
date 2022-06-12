package com.be.finalproject.nightmodejavaapp;

import android.content.Context;
import android.content.SharedPreferences;

public class AbsoluteSettingBean {
    SharedPreferences themePreference ;

    public AbsoluteSettingBean(Context context) {
        themePreference = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    //setter for theme
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = themePreference.edit();
        editor.putBoolean("NightMode",state);
        editor.commit();
    }

    // loader for theme
    public Boolean loadNightModeState (){
        Boolean state = themePreference.getBoolean("NightMode",false);
        return  state;
    }
}
