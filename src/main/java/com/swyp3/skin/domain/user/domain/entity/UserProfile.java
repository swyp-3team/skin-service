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

    private String profileImageUrl;


    private UserProfile(User user, String profileImageUrl) {
        this.user = user;
        this.profileImageUrl = profileImageUrl;
    }

    public static UserProfile create(User user, String profileImageUrl) {
        return new UserProfile(user, profileImageUrl);
    }
}
