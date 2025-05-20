package org.example.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Empresa {
    private String nombre;
    private String razonSocial;
    private Integer cuil;
    private Set<Sucursal> sucursales;

    public Empresa(String nombre, Integer cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }

    public void addSucursal(Sucursal sucursal) {
        if (this.sucursales == null) {
            this.sucursales = new HashSet<Sucursal>();
        }
        this.sucursales.add(sucursal);
    }
    public void removeSucursal(Sucursal sucursal) {
        this.sucursales.remove(sucursal);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuil=" + cuil +
                ", sucursales=" + sucursales +
                '}';
    }
}
