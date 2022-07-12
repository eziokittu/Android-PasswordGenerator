package com.example.p_passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Button btn_save1, btn_save2, btn_validate, btn_generate;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        btn_save1 = findViewById(R.id.btn_save1);
        btn_save2 = findViewById(R.id.btn_save2);
        btn_validate = findViewById(R.id.btn_validate);
        btn_generate = findViewById(R.id.btn_generate);
        textView2 = findViewById(R.id.textView2);

        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editText1.getText().toString();
                if (CheckPasswordValidity(password)){
                    Toast.makeText(MainActivity.this, "Password is Valid", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Password is NOT Valid", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText(GenerateRandomPassword());
            }
        });

        btn_save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editText1.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText1", password);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Password is saved in clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        btn_save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = textView2.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText1", password);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Password is saved in clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean CheckPasswordValidity(String s) {
        String specialAllowed = new String("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

        Boolean isSpecial;
        Boolean isNumber;
        Boolean isUpper;
        Boolean isLower;

        Integer countUpper=0;
        Integer countLower=0;
        Integer countDigit=0;
        Integer countSpecial=0;

        if (s.length()<8 || s.length()>20) return false;

        // Iterating through each letter in the password
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            isSpecial = false;
            isNumber = false;
            isUpper = false;
            isLower = false;

            if (Character.isUpperCase(c)){
                isUpper = true;
                countUpper+=1;
                continue;
            }
            else if (Character.isLowerCase(c)){
                isLower = true;
                countLower+=1;
                continue;
            }
            else if (Character.isDigit(c)){
                isNumber = true;
                countDigit+=1;
                continue;
            }
            else if (c == ' '){
                return false;
            }
            for (int j=0; j<specialAllowed.length(); j++) {
                char sp = specialAllowed.charAt(j);
                if (c == sp) {
                    isSpecial = true;
                    countSpecial+=1;
                    continue;
                }

            }
            if (isSpecial == false && isNumber == false && isUpper == false && isLower == false) {
                return false;
            }
        }
        if (countUpper>=1 && countLower>=1 && countDigit>=1 && countSpecial>=1) return true;
        else return false;
    }

    public String GenerateRandomPassword(){
        String specials = new String("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        String upper = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String lower = new String("abcdefghijklmnopqrstuvwxyz");
        String numbers = new String("0123456789");
        String password = "New Password";

        Random random = new Random();

        Boolean passwordIsValid = false;

        // length for password is between 8 to 20 characters
        int r1 = random.nextInt(21-8) + 8;

        while (!passwordIsValid) {
            password = "";

            // Iterating the range r1
            for (int i = 0; i < r1; i++) {
                int r2 = random.nextInt(4000);
                int r3;

                // for special characters
                if (r2 >= 0 && r2 < 1000) {
                    r3 = random.nextInt(specials.length());
                    password += specials.charAt(r3);
                }

                // for uppercase
                else if (r2 >= 1000 && r2 < 2000) {
                    r3 = random.nextInt(upper.length());
                    password += upper.charAt(r3);
                }

                // for numbers
                else if (r2 >= 2000 && r2 < 3000) {
                    r3 = random.nextInt(numbers.length());
                    password += numbers.charAt(r3);
                }

                // for lowercase
                else if (r2 >= 3000 && r2 < 4000) {
                    r3 = random.nextInt(lower.length());
                    password += lower.charAt(r3);
                }
            }

            // Check if password is valid
            passwordIsValid = CheckPasswordValidity(password); // if true, loop breaks
        }

        return password;
    }
}