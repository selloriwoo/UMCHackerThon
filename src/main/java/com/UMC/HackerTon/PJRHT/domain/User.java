package com.UMC.HackerTon.PJRHT.domain;


import com.UMC.HackerTon.PJRHT.domain.common.BaseEntity;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Long money;

    @Column(nullable = false, length = 20)
    private String account;

    @Column(nullable = false, length = 30)
    private String pwd;

    private String pic;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Heart> heartList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Qna> qnaList = new ArrayList<>();

}
