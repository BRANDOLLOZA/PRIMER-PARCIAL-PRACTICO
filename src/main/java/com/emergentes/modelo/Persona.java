package com.emergentes.modelo;

public class Persona {
    private int id;
    private String nombres;
    private int edad;
    private int P1;
    private int P2;
    private int P3;
    private int Nota;
    
    public Persona() {
        this.id=0;
        this.nombres = "";
        this.P1 = 0;
        this.P2 = 0;
        this.P3 = 0;
        this.Nota = 0;       
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getP1() {
        return P1;
    }

    public void setP1(int P1) {
        this.P1 = P1;
    }

    public int getP2() {
        return P2;
    }

    public void setP2(int P2) {
        this.P2 = P2;
    }

    public int getP3() {
        return P3;
    }

    public void setP3(int P3) {
        this.P3 = P3;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }

   
}
