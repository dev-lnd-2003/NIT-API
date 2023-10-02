package com.website.nit.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "News")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "Publish_Date")
    private Date publishDate;

    private String author;

    private String category;

    private String url;

    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "news")
    List<Comments> comment;

    @JsonIgnore
    @OneToMany(mappedBy = "news")
    List<Likes> like;

    @JsonIgnore
    @OneToMany(mappedBy = "news")
    List<Report> report;
}
