package com.example.albun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewContacts = findViewById(R.id.AlbunList);

        List<Albun> albunes= Albun.listAll(Albun.class);
        recyclerViewContacts.setHasFixedSize(true);
        //add new albun
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewContacts.setLayoutManager(layoutManager);
        AlbunAdapter adapter = new AlbunAdapter(albunes);
        adapter.setOnItemClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name =  ((TextView)view.findViewById(R.id.nameAlbun)).getText().toString();
                String id =  ((TextView)view.findViewById(R.id.id)).getText().toString();
                Intent intent = new Intent(getApplicationContext(),AlbunInfo.class);
                intent.putExtra("NAME",name);
                intent.putExtra("ID",id);
                ChangeActiviy(intent);
            }
        });
        recyclerViewContacts.setAdapter(adapter);


        Button newAlbun = findViewById(R.id.NewAlbunButton);

        newAlbun.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NewAlbun.class);
                ChangeActiviy(intent);
            }
        });
    }
    public void ChangeActiviy(Intent intent){
        try {

            startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }
    }

}