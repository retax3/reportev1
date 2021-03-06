package com.example.sicom.reportev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {
Button btnIngresar,btnRegistrarse;
EditText rut;
String strRUT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = findViewById(R.id.bIngresarInsidencia);
        rut = findViewById(R.id.editRUT);


        /*al presioanr boton ingresar valida al usuario por rut,en caso contrario envia un mensaje para que
        ingrese rut valido o se registre el usuario */
        btnIngresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                strRUT=rut.getText().toString();

                if (validarRut(strRUT)) {
                    Toast.makeText(MainActivity.this,"Usuario correcto",
                            Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Categorias.class);
                    startActivity(intent);
                }
                else Toast.makeText(MainActivity.this, "Su RUT es invalido " +
                        "o Usuario no registrado", Toast.LENGTH_SHORT).show();
            }
        });

   /*     btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registrarse.class);
                startActivity(intent);

            }
        });*/
    }

    private static boolean validarRut(String rut){
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}
