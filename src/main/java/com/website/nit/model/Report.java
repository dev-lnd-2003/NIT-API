package com.website.nit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Report")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reason;

    @Temporal(TemporalType.DATE)
    @Column(name = "Create_Date")
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    Users users;

    @ManyToOne
    @JoinColumn(name = "News_ID")
    News news;
}
