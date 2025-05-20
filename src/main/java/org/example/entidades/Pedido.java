package org.example.entidades;

import enumerables.Estado;
import enumerables.FormaPago;
import enumerables.TipoEnvio;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private TipoEnvio tipoEnvio;
    private Estado estado;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    private Set<DetallePedido> detalles;
    private Factura factura;
    private Sucursal sucursal;
    private Domicilio domicilio;  //cliente

    //lo cree con valores por defecto.
    public Pedido(double totalCosto) {
        this.estado = Estado.PENDIENTE;
        this.tipoEnvio = TipoEnvio.DELIVERY;
        this.formaPago= FormaPago.MERCADOPAGO;
        this.totalCosto = totalCosto;
    }
    public void addDetallePedido(DetallePedido detallePedido){
        if(this.detalles == null){
            this.detalles = new HashSet<DetallePedido>();
        }
    }
    public void removeDetallePedido(DetallePedido detallePedido){
        this.detalles.remove(detallePedido);
    }
    //le deje todos los datos.
    @Override
    public String toString() {
        return "Pedido{" +
                "horaEstimadaFinalizacion=" + horaEstimadaFinalizacion +
                ", total=" + total +
                ", totalCosto=" + totalCosto +
                ", tipoEnvio=" + tipoEnvio +
                ", estado=" + estado +
                ", formaPago=" + formaPago +
                ", fechaPedido=" + fechaPedido +
                ", detalles=" + detalles +
                ", factura=" + factura +
                ", sucursal=" + sucursal +
                ", domicilio=" + domicilio +
                '}';
    }
}
