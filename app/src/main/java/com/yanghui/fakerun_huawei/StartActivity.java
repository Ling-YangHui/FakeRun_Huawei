package com.yanghui.fakerun_huawei;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class StartActivity extends Activity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button start_generate = findViewById(R.id.start_generate);
        EditText start_distance = findViewById(R.id.start_distance);
        EditText start_time = findViewById(R.id.start_time);
        EditText start_margin = findViewById(R.id.start_margin);

        start_generate.setOnClickListener(v -> {
            if (!start_distance.getText().toString().isEmpty() && !start_time.getText().toString().isEmpty()) {
                try {
                    String distance = start_distance.getText().toString();
                    dataHold.distance = distance;
                    dataHold.time = start_time.getText().toString();

                    String[] time = dataHold.time.split(":");
                    int consumeSeconds = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
                    int seconds = (int) (consumeSeconds / Double.parseDouble(distance));
                    dataHold.timePerKM = seconds / 60 + "'" + seconds % 60 + "''";
                    int energy =
                            (int)  (Double.parseDouble(distance) * (new Random().nextInt(7) + 70));
                    dataHold.energy = Integer.toString(energy);

                    double speed = Double.parseDouble(distance) / consumeSeconds * 3600;
                    dataHold.speed = String.format("%.2f", speed);

                    dataHold.stepFre = new Random().nextInt(19) + 126 + "";
                    dataHold.stepLen = new Random().nextInt(7) + 87 + "";
                    dataHold.stepNum =
                            (int) (Double.parseDouble(distance) * (new Random().nextInt(50) + 1093)) + "";

                    if (!start_margin.getText().toString().isEmpty()) {
                        dataHold.margin = Integer.parseInt(start_margin.getText().toString());
                    } else {
                        dataHold.margin = 247;
                    }

                    Intent main = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(main);
                } catch (Exception e) {
                    Toast.makeText(this, "请输入正确的时间格式\"xx:xx:xx\"", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(this, "输入为空！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}