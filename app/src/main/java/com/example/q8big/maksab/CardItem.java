package com.example.q8big.maksab;

/**
 * Created by q8big on 13/03/2018.
 */

class Project {
    String name;

    int photoId;

    Project(String name, int photoId) {
        this.name = name;


        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}