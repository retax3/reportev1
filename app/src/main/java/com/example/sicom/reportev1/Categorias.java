package com.example.sicom.reportev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.Normalizer;

public class Categorias extends AppCompatActivity {
ListView categorias;
Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        categorias=findViewById(R.id.listacategorias);

        String cat[]={"Alumbrado Publico","Mobiliario","Semaforos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,cat);
        categorias.setAdapter(adapter);

        next=findViewById(R.id.bNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categorias.this,Formulario.class);
                startActivity(intent);
            }
        });
    }
}
