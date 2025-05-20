package org.example.entidades;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localidad {
    private String nombre;
    private Provincia provincia;

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Localidad{" +
                "nombre='" + nombre + '\'' +
                ", provincia=" + provincia +
                '}';
    }
}