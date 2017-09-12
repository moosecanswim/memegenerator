package me.moosecanswim.memegenerator.model;

import javax.persistence.*;

@Entity
public class InputImage {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imageLocation;
    private Boolean status;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Uzer author;


    //*******************************constructor*************************
    public InputImage(){
        status=true;
    }

    //****************************************Getters and setters***********************************
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Uzer getAuthor() {
        return author;
    }

    public void setAuthor(Uzer author) {
        this.author = author;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
