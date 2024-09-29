package com.xbrlconverter.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Certificates")
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer certificateId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "organization")
    private String organization;

    @Column(name = "issue_date")
    private java.sql.Date issueDate;

    @Column(name = "expiration_date")
    private java.sql.Date expirationDate;


}

