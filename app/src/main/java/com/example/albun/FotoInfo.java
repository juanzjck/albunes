package com.example.albun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;


public class FotoInfo extends AppCompatActivity {
    ImageView imageViewNCImage;
    // image = R.drawable.usuario1;
    String image;
    EditText textName,textPhone,textAddress;
    SharedPreferences sharedpreferences;
    int count =0;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foto_info);

        Button camera =  findViewById(R.id.camara);

        camera.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Camera(view);
            }
        });


        sharedpreferences = getSharedPreferences("contacts", getApplicationContext().MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    public void Camera(View v){
        count = sharedpreferences.getInt("imagen",0);
        count++;
        String Folder="/" + "fotouser"+count+".jpg";
        image = getExternalFilesDir(Environment.DIRECTORY_PICTURES)+Folder;


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        editor.putInt("imagen",count);
        editor.commit();

        //Uri output = Uri.fromFile(new File(photo));
        Uri output = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID+".fileprovider"
                , new File(image));


        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
        startActivityForResult(intent, 0);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == this.RESULT_OK) {
                    File fileTemp = new File(image);
                    if (!fileTemp.exists()) {
                        Toast.makeText(this,
                                "No se ha realizado la foto", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        imageViewNCImage.setImageBitmap(BitmapFactory.decodeFile(image));
                    }
                }

                break;
            case 1:


                if (resultCode == this.RESULT_OK) {
                    Uri uri = data.getData();
                    String[] projection = {MediaStore.Images.Media.DATA};
                    Cursor cursor = this.getContentResolver().query(uri, projection,
                            null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(projection[0]);
                    image = cursor.getString(columnIndex); // returns null
                    cursor.close();
                    imageViewNCImage.setImageBitmap(BitmapFactory.decodeFile(image));
                }
                break;
        }

    }
}