package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DatePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(),
//                getString(R.string."d"));
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        Toast.makeText(this, "Date : " + dateMessage,
                Toast.LENGTH_SHORT).show();
    }
}