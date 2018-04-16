package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;

public class GesturePasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "GesturePasswordActivity";

    public static final String LOCK = "lock";
    public static final String LOCK_KEY = "lock_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_password);
        SharedPreferences preferences = getSharedPreferences(LOCK, MODE_PRIVATE);

        String lockPattenString = preferences.getString(LOCK_KEY, null);

        if (lockPattenString != null) {
            Intent intent = new Intent(this, LockActivity.class);
            startActivity(intent);

        }
    }    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lock:
                Intent intent = new Intent(this, LockSetupActivity.class);
                startActivity(intent);
                break;
            case R.id.unlock:
                getSharedPreferences(LOCK, MODE_PRIVATE).edit().clear().commit();
                break;

            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
