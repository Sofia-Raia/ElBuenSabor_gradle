package org.example.entidades;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido {
    private Integer cantidad;
    private double subTotal;
    private Articulo articulo;
    private Promocion promocionDetalle;

    public DetallePedido(Articulo articulo, Integer cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        //this.subTotal.calcularSubTotal();
    }

    public DetallePedido(Integer cantidad, Promocion promocionDetalle) {
        this.cantidad = cantidad;
        this.promocionDetalle = promocionDetalle;
        //this.subTotal.calcularSubTotal();
    }
    public void calcularSubTotal(){
        if(promocionDetalle != null){
            //completar
        }

    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subTotal=" + subTotal +
                ", articulo=" + articulo +
                '}';
    }
}

