package com.example.sicom.reportev1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Formulario extends AppCompatActivity {
static final int requestCamara =1;
ImageView vistaPrevia;
Button camara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        camara = findViewById(R.id.foto);
        vistaPrevia = findViewById(R.id.viewCamara);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto();
            }
        });



    }



    private void tomarFoto(){
        Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (foto.resolveActivity(getPackageManager())!= null){
            startActivityForResult(foto,requestCamara);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==requestCamara && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            vistaPrevia.setImageBitmap(imageBitmap);
        }
    }
}
