package com.example.sicom.reportev1;

import android.graphics.Bitmap;

public class Insidencias {
    private Bitmap foto;
    private String descripcion,rut;
    private double lat,lng;

    public Insidencias(String descripcion,
                       double lat,
                       double lng,
                       Bitmap foto){
        this.descripcion=descripcion;
        this.lat=lat;
        this.lng=lng;
        this.foto=foto;
    }

}
