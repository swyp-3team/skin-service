package com.swyp3.skin.domain.user.domain.entity;

import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String nickname;

    private String profileImageUrl;


    private UserProfile(User user, String nickname, String profileImageUrl) {
        this.user = user;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static UserProfile create(User user, String nickname, String profileImageUrl) {
        return new UserProfile(user, nickname, profileImageUrl);
    }
}
