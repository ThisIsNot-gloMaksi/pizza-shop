package com.glomaksi.pizzashopbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images")
@NoArgsConstructor
@Data
public class ImageFile {
    @Id
    @GeneratedValue
    @Column(name = "image_id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Date date;

    public ImageFile(String url) {
        this.url = url;
        this.date = new Date();
    }
}
