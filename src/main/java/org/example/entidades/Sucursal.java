package org.example.entidades;

import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Domicilio domicilio;
    private Set<Categoria> categorias;
    private Set<Promocion> promociones;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.horarioApertura = LocalTime.of(14, 30);
        this.horarioCierre = LocalTime.of(22, 30);
    }

    public void addCategoria(Categoria categoria) {
        if(categorias == null) {
            categorias = new HashSet<>();
        }
        categorias.add(categoria);

    }
    public void removeCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }
    public void addPromocion(Promocion promocion) {
        if(promociones == null) {
            promociones = new HashSet<>();
        }
        promociones.add(promocion);
    }
    public void removePromocion(Promocion promocion) {
        this.promociones.remove(promocion);
    }

    //no muestro los sets de promocion y categoria.
    @Override
    public String toString() {
        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", horarioApertura=" + horarioApertura +
                ", horarioCierre=" + horarioCierre +
                ", domicilio=" + domicilio +
                '}';
    }
}

