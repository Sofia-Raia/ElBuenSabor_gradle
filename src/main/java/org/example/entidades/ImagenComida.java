package org.example.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ImagenComida {
    private String denominacion;

    public ImagenComida(String denominacion) {
        this.denominacion = denominacion;
    }


}
