package com.example.yyiwen.fastmaildemo.Activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.VoicePlayingBgUtil;

public class VoiceActivity extends AppCompatActivity {
    Button button;
    VoicePlayingBgUtil playBgUtil;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        button= (Button) findViewById(R.id.voice);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBgUtil = new VoicePlayingBgUtil(handler);
                playBgUtil.stopPlay();
                playBgUtil.voicePlay();
            }
        });
    }
}
