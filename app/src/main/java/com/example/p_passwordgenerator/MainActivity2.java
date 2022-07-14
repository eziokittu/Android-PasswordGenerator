package com.example.p_passwordgenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

//    DBHelper DB;

    Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_Back = findViewById(R.id.activity2_btn_Back);

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // For Database - viewing the Database
//        DB = new DBHelper(this);
//        Cursor res = DB.getdata();
//        if(res.getCount()==0){
//            Toast.makeText(MainActivity2.this, "No database entries exist", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        StringBuffer buffer = new StringBuffer();
//        while(res.moveToNext()){
//            buffer.append("Serial No. :"+res.getString(0)+"\n");
//            buffer.append("Password :"+res.getString(1)+"\n\n");
//        }
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
//        builder.setCancelable(true);
//        builder.setTitle("User Entries");
//        builder.setMessage(buffer.toString());
//        builder.show();
    }
}