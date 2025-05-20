package org.example.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ArticuloManufacturadoDetalle {
    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;

    public ArticuloManufacturadoDetalle(Integer cantidad, ArticuloInsumo articuloInsumo) {
        this.cantidad = cantidad;
        this.articuloInsumo = articuloInsumo;
    }

    @Override
    public String toString() {
        return "ArticuloManufacturadoDetalle{" +
                "cantidad=" + cantidad +
                ", articuloManufacturado=" + articuloInsumo.getDenominacion() +
                '}';
    }
}

