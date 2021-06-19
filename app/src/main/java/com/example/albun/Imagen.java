package com.example.albun;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Imagen  extends SugarRecord implements Serializable {
    private String image;
    private long albun_id;

    public Imagen(String image, long albun_id) {
        this.image = image;
        this.albun_id = albun_id;
    }

    public Imagen() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getAlbun_id() {
        return albun_id;
    }

    public void setAlbun_id(long albun_id) {
        this.albun_id = albun_id;
    }
}
