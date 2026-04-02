package com.swyp3.skin.domain.user.domain.entity;

import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.AuthProvider;

@Entity
@Getter
@NoArgsConstructor
public class UserOauth extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider provider;

    @Column(nullable = false)
    private String providerUserId;

    private String email;
}
