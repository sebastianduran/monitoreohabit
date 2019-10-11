package com.example.hotelkensymanager;

public class Ocupacion {
    int Habitacion;
    int presencia;

    public Ocupacion() {
    }

    public Ocupacion(int habitacion, int presencia) {
        Habitacion = habitacion;
        this.presencia = presencia;
    }

    public int getHabitacion() {
        return Habitacion;
    }

    public void setHabitacion(int habitacion) {
        Habitacion = habitacion;
    }

    public int isPresencia() {
        return presencia;
    }

    public void setPresencia(int presencia) {
        this.presencia = presencia;
    }
}
