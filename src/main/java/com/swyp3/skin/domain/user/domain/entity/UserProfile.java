package com.swyp3.skin.domain.user.domain.entity;

import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String nickname;

    private String profileImageUrl;
}
