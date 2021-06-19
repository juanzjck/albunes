package com.example.albun;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Albun extends SugarRecord implements Serializable {
    private long id;
    private String nombre;

    public Albun(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Albun( String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Albun() {
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
