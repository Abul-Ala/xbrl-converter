package com.xbrlconverter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer skillId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "proficiency")
    private Integer proficiency;

}

