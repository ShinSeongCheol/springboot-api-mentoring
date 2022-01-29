package com.example.springbootapi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String number;

    private String email;

    //MemberCreateRequest -> Member로 변환해주는 과정이 필요
    public static Member toEntity(MemberCreateRequest request) {
        return Member.builder()
                .name(request.getName())
                .number(request.getNumber())
                .email(request.getEmail())
                .build();
    }

    public void updateName(String name){
        this.name = name;
    }
}
