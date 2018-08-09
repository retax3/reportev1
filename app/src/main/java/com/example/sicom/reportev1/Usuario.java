package com.example.sicom.reportev1;

public class Usuario{
    private int rut;
    private String email,nombre,apellido1,appelido2,comuna,password,nick;

    public Usuario (int rut,String nombre,String apellido1,
                    String appelido2,String comuna,String email,String password,String nick){

    }


    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getAppelido2() {
        return appelido2;
    }

    public void setAppelido2(String appelido2) {
        this.appelido2 = appelido2;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
