package com.yanghui.fakerun_huawei;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View main_back = findViewById(R.id.main_back);
        TextView main_time = findViewById(R.id.main_time);
        TextView main_distance = findViewById(R.id.main_distance);
        TextView main_exerciseTime = findViewById(R.id.main_exercise_time);
        TextView main_energy = findViewById(R.id.main_energy);
        TextView main_averageTimePerKM = findViewById(R.id.main_average_time);
        TextView main_averageSpeed = findViewById(R.id.main_average_speed);
        TextView main_averageStepFre = findViewById(R.id.main_average_step_fre);
        TextView main_averageStepLen = findViewById(R.id.main_average_step_len);
        LinearLayout main_underline = findViewById(R.id.main_underline);
        TextView main_step = findViewById(R.id.main_step);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LayoutTool.dip2px(this, 38), LayoutTool.dip2px(this, 3));
        params.setMarginStart(LayoutTool.dip2px(this, dataHold.margin));
        main_underline.setLayoutParams(params);
        main_time.setText(new SimpleDateFormat("yyyy年M月d日 HH:mm").format(new Date()));
        main_distance.setText(dataHold.distance);
        main_exerciseTime.setText(dataHold.time);
        main_energy.setText(dataHold.energy);
        main_averageTimePerKM.setText(dataHold.timePerKM);
        main_averageSpeed.setText(dataHold.speed);
        main_averageStepFre.setText(dataHold.stepFre);
        main_averageStepLen.setText(dataHold.stepLen);
        main_step.setText(dataHold.stepNum);
        main_back.setOnClickListener(v -> finish());
    }
}