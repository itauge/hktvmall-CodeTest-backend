package com.example.hktvmallcodetest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "holiday")
@NoArgsConstructor
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dtstart")
    private Date dtstart;

    @Column(name = "dtend")
    private Date dtend;

    @Column(name = "transp")
    private String transp;

    @Column(name = "uid")
    private String uid;

    @Column(name = "summary")
    private String summary;

}
