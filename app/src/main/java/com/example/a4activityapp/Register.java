package com.example.a4activityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register extends Activity {
    EditText Name;
    EditText Email;
    EditText Age;
    android.widget.Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelayout);
        //View form Button
        Button button =(Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().trim().isEmpty()){
                    Name.setError("Please enter your name");
                    Name.requestFocus();
                }
                else if (!isValidEmail(Email.getText().toString()))
                {
                    Email.setError("Please enter your Email");
                    Email.requestFocus();
                }
                else if (Age.getText().toString().trim().isEmpty()){
                    Age.setError("Please enter your Age");
                    Age.requestFocus();
                }
                else {
                    sendMessage();
                }
            }
        });
        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Age=(EditText)findViewById(R.id.age);

    }
    private boolean isValidEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }


    public void sendMessage(){
        Intent intent =new Intent(Register.this,AboutMe.class);
        intent.putExtra("name",Name.getText().toString());
        intent.putExtra("email",Email.getText().toString());
        intent.putExtra("age",Age.getText().toString());

    }
}

