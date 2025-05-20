package org.example.entidades;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private boolean esParaElaborar;

    public ArticuloInsumo(String denominacion, Double precioVenta, UnidadMedida unidadMedida, double precioCompra) {
        super(denominacion, precioVenta, unidadMedida);
        this.precioCompra = precioCompra;
    }


    //no muestro imagen, stockActual, stockMaximo.
    @Override
    public String toString() {
        return "ArticuloInsumo{" +
                ", denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                "precioCompra=" + precioCompra +
                ", unidadMedida=" + unidadMedida +
                ", esParaElaborar=" + esParaElaborar +
                '}';
    }
}
