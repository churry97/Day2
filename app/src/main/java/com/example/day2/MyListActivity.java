package com.example.day2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    TextView et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        init();
    }

    private void init(){
        data.add("사과");
        data.add("바나나");
        data.add("체리");

        //recycler view
        adapter = new MyListAdapter(this.data);
        recyclerView = findViewById(R.id.fruitlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        et = findViewById(R.id.etFruit);
    }

    public void onAdd(View view){
        String newfruit = et.getText().toString();
        data.add(newfruit);
        adapter.notifyDataSetChanged();
    }
}

