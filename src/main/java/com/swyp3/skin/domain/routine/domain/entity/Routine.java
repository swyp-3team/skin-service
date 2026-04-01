package com.swyp3.skin.domain.routine.domain.entity;

import com.swyp3.skin.domain.routine.domain.enums.RoutineType;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Routine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private User user;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private RoutineType routineType;
    private String title;
    private String memo;
}