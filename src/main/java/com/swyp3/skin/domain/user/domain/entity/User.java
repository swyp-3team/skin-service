package com.swyp3.skin.domain.user.domain.entity;

import com.swyp3.skin.domain.user.domain.enums.UserRole;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    private User(UserRole role){
        this.role = role;
    }

    public static User create(UserRole role) {
        return new User(role); //정적 팩토리 메서드 사용
    }
}
