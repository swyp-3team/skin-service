package com.swyp3.skin.domain.routine.domain.entity;

import com.swyp3.skin.domain.skintest.domain.entity.SkinResult;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SkinResult skinResult;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String summary;

    @Column(length = 500)
    private String caution;
}
