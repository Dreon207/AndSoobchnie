package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_pick_btn);
        timeBtn = findViewById(R.id.time_pick_btn);
        applyBtn = findViewById(R.id.apply_btn);


        dateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                int year = 2014;
                int month = 10;
                int day = 10;

                DatePickerDialog.OnDateSetListener datePick = new DatePickerDialog.OnDateSetListener() {
                    @Override//Выбор даты
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateTxt.setText("" + i2 + "-" + (i1+1) + "-" + i);
                    }
                };

                DatePickerDialog datePickerDialog= new DatePickerDialog(MainActivity.this, datePick,year, month, day);
                datePickerDialog.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int hours =12;
                int minute = 30;
                boolean is24Format = true;

                TimePickerDialog.OnTimeSetListener timePick = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        timeTxt.setText(i+":"+i1);
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timePick,hours,minute,is24Format);
                timePickerDialog.show();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Подтверждение записи")
                    .setMessage("Вы родтвердиди запись?")
                    .setIcon(R.drawable.ic_date)
                    .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            Toast.makeText(MainActivity.this, "Вы успешно записаны", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create();
            builder.show();
            }
        });
    }

}



