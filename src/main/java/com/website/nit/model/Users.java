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
@Table(name = "Users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String username;

    private String password;

    @Column(name = "Fullname")
    private String fullName;

    private String avatar;

    private String email;

    private Boolean gender;

    @Column(name = "Reset_Code")
    private String resetCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "Create_Date")
    private Date createDate;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    List<Comments> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    List<Likes> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    List<Report> report;

}
