package com.example.sicom.reportev1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class Formulario extends AppCompatActivity {
static final int requestCamara =10,requestMap=20;
private ImageView vistaPrevia;
private Button camara,ubicacion;
private Bitmap imageBitmap;
private LatLng latlng;
private double lat,lng;
private String categoria;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Bundle bundle =getIntent().getExtras();
        categoria=bundle.getString("categoria");

        ubicacion = findViewById(R.id.bUbicacion);

        camara = findViewById(R.id.foto);
        vistaPrevia = findViewById(R.id.viewCamara);


        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto();
            }
        });


        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map= new Intent(Formulario.this,MapsActivity.class);
                map.putExtra("latylong",latlng);
                startActivityForResult(map,requestMap);
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
            imageBitmap = (Bitmap) extras.get("data");
            vistaPrevia.setImageBitmap(imageBitmap);
            Toast.makeText(this, "Imagen guardada", Toast.LENGTH_SHORT).show();
        }
        if (requestCode==requestMap &&  resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            latlng = (LatLng) extras.get("latylong");
            Toast.makeText(this,"Ubicacion obtenida con exito",Toast.LENGTH_LONG).show();

        }
        if (requestCode==30 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            categoria = (String) extras.get("categoria");
            }

    }

}
