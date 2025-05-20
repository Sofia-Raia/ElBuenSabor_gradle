package org.example.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Pais {
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}