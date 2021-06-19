package com.example.albun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewAlbun extends AppCompatActivity {

    EditText textName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_albun);
        textName = findViewById(R.id.textInputName);
    }

    public void SaveAlbun(View v){
        String Name=textName.getText().toString();
        Albun newAlbun=new Albun(Name);
        newAlbun.save();
        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Cancel(View v){
         try {
             Intent intent = new Intent(getApplicationContext(),MainActivity.class);

             startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }
    }
}