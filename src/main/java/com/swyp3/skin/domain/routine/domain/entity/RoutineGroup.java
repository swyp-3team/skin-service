package com.swyp3.skin.domain.routine.domain.entity;

import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
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

    @Column(nullable = false, length = 100)
    private String skinType;

    @Column(length = 100)
    private String subtitle;

    @Column(length = 500)
    private String summary;

    public static RoutineGroup of(
            User user,
            SkinResult skinResult,
            String title,
            String skinType,
            String subtitle,
            String summary
    ) {
        RoutineGroup routineGroup = new RoutineGroup();
        routineGroup.user = user;
        routineGroup.skinResult = skinResult;
        routineGroup.title = title;
        routineGroup.skinType = skinType;
        routineGroup.subtitle = subtitle;
        routineGroup.summary = summary;
        return routineGroup;
    }
}
