package org.example.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UnidadMedida {
    private String denominacion;

    public UnidadMedida(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return "UnidadMedida{ " +
                denominacion + '\'' +
                '}';
    }
}
