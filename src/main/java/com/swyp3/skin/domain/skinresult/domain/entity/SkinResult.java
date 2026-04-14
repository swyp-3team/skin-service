package com.swyp3.skin.domain.skinresult.domain.entity;

import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkinResult extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkinType skinType;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private LocalDateTime diagnosedAt;

    private SkinResult(User user, SkinType skinType, String summary, LocalDateTime diagnosedAt) {
        this.user = user;
        this.skinType = skinType;
        this.summary = summary;
        this.diagnosedAt = diagnosedAt;
    }

    public static SkinResult create(
            User user,
            SkinType skinType,
            String summary,
            LocalDateTime diagnosedAt) {
        return new SkinResult(user, skinType, summary, diagnosedAt);
    }
}
