package com.example.albun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class AlbunInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albun_info);

        String id=(String) getIntent().getSerializableExtra("ID");
        String name=(String) getIntent().getSerializableExtra("NAME");

        TextView textView = findViewById(R.id.nameAlbun);
        textView.setText(name);

    }

    public void newImage(View v){
        Intent intent = new Intent(getApplicationContext(),FotoInfo.class);

        startActivity(intent);
    }
}