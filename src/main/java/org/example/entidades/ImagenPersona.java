package org.example.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ImagenPersona {
    private String denominacion;

    public ImagenPersona(String denominacion) {
        this.denominacion = denominacion;
    }


}