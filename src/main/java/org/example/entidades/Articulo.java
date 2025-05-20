package org.example.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public abstract class Articulo {
    protected String denominacion;
    protected Double precioVenta;

    protected UnidadMedida unidadMedida;
    protected Set<ImagenComida> imagenes;

    public Articulo(String denominacion, Double precioVenta) {
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
    }

    public Articulo(String denominacion, Double precioVenta, UnidadMedida unidadMedida) {
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
        this.unidadMedida = unidadMedida;
    }


    public void addImagen(ImagenComida imagen) {
        if (imagenes == null) {
            imagenes = new HashSet<ImagenComida>();
        }
        this.imagenes.add(imagen);
    }
    public void removeImagen(ImagenComida imagen) {
        this.imagenes.remove(imagen);
    }
    //no muestro imagen.
    @Override
    public String toString() {
        return "Articulo{" +
                "denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                ", unidadMedida=" + unidadMedida +
                '}';
    }
}
