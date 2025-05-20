package org.example.entidades;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Usuario {
    private String auth0Id;
    private String username;

    public Usuario(String auth0Id, String username) {
        this.auth0Id = auth0Id;
        this.username = username;
    }

}
