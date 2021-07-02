package com.example.day2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogueActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1, b2, b3, b4;
    int selected = 0;
    String menu[] = {"치킨", "피자", "스파게티"};
    boolean checked[] = {true, true, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);

        init();
    }

    private void init(){
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }
    //3번째 방법 event handler
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            displayDialogue();
        }
        else if(v.getId() == R.id.button2){
            displayDialogue2();
        }
        else if(v.getId() == R.id.button3){
            displayDialogue3();
        }
        else if(v.getId() == R.id.button4){
            displayDialogue4();
        }
    }

    private void displayDialogue() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자");
        dlg.setMessage("대화상자 메세지입니다.");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {//string, eventhandler
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(null);
            }
        });
        dlg.show();
    }

    //Radiobutton
    private void displayDialogue2() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자2");
        dlg.setSingleChoiceItems(menu, selected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected = which;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() { //string, eventhandler
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selected] + "가 선택되었습니다!");
            }
        });
        dlg.show();
    }

    private void displayDialogue3() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자2");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() { //string, eventhandler
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String list = "";
                for (int i = 0; i < checked.length; i++) {if(checked[i]) list = list + " " + menu[i];
                displayToast(menu[selected] + "(이)가 선택되었습니다!");}
            }
        });
        dlg.show();
    }

    private void displayDialogue4() {
        View view = View.inflate(this, R.layout.dialogue, null);
        final EditText editText = view.findViewById(R.id.etMsg);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정의 대화상");

        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(view);
        dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() { //string, eventhandler
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("입력한 메세지 : " + editText.getText().toString());
            }
        });
        dlg.setPositiveButton("취소", null);
        dlg.show();
    }

    private void displayToast(String msg){
        if (msg == null) Toast.makeText(this, "OK, Clicked!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}