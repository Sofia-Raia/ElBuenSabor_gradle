package org.example.entidades;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    private Set<Pedido> pedidos;
    private Set<Domicilio>domicilios; //puede pedir de diferentes lugares.
    private Usuario usuario;
    private ImagenPersona imagenCliente;

    public Cliente(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }


    public void addPedido(Pedido pedido) {
        if (this.pedidos == null) {
            this.pedidos = new HashSet<Pedido>();
        }
        this.pedidos.add(pedido);
    }
    public void removePedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
    public void addDomicilio(Domicilio domicilio) {
        if (this.domicilios == null) {
            this.domicilios = new HashSet<>();
        }
        this.domicilios.add(domicilio);
    }
    public void removeDomicilio(Domicilio domicilio) {
        this.domicilios.remove(domicilio);
    }
    //solo muestro algunos datos.
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
