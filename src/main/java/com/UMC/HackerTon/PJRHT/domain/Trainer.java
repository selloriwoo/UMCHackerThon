package com.UMC.HackerTon.PJRHT.domain;

import com.UMC.HackerTon.PJRHT.domain.common.BaseEntity;
import com.UMC.HackerTon.PJRHT.domain.mapping.Heart;
import com.UMC.HackerTon.PJRHT.domain.mapping.Qna;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
public class Trainer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Long money;

    private String pic;

    @Column(nullable = false)
    private Long PTOneCost;

    @ColumnDefault("0")
    private Float starPointAVG;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Heart> heartList = new ArrayList<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Qna> qnaList = new ArrayList<>();
}
