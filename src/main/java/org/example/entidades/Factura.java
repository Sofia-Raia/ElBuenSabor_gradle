package org.example.entidades;

import lombok.*;
import org.example.enumerables.FormaPago;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura {
    private LocalDate fechaFacturacion;
    private Integer mpPaymentId;
    private Integer mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private double totalVenta;

    //LE DEJE LA FORMA DE PAGO POR DEFECTO
    public Factura(LocalDate fechaFacturacion, double totalVenta) {
        this.fechaFacturacion = fechaFacturacion;
        this.formaPago = FormaPago.MERCADOPAGO;
        this.totalVenta = totalVenta;
    }



    //Faltan datos.. que son los que creo que no van.
    @Override
    public String toString() {
        return "Factura{" +
                "fechaFacturacion=" + fechaFacturacion +
                ", formaPago=" + formaPago +
                ", totalVenta=" + totalVenta +
                '}';
    }
}

