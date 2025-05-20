package org.example.entidades;


import lombok.*;
import org.example.enumerables.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private org.example.enumerables.TipoPromocion tipoPromocion;

    private Set<ImagenComida> imagenes ;
    private Set<Articulo> articulos;

    public Promocion(String denominacion) {
        this.denominacion = denominacion;
    }


    //se lo deje por defecto..
    public void setTipoPromocion(TipoPromocion tipoPromocion) {
        this.tipoPromocion = TipoPromocion.HAPPYHOUR;
    }
    public void addImagen(ImagenComida imagen) {
        if (imagenes == null) {
            imagenes = new HashSet<>();
        }
        imagenes.add(imagen);
    }
    public void removeImagen(ImagenComida imagen) {
        this.imagenes.remove(imagen);
    }
    public void addArticulo(Articulo articulo) {
        if (articulos == null) {
            articulos = new HashSet<>();
        }
        this.articulos.add(articulo);
    }
    public void removeArticulo(Articulo articulo) {
        this.articulos.remove(articulo);
    }

    //no muestra los sets de imagenes y articulos.
    @Override
    public String toString() {
        return "Promocion{" +
                "denominacion='" + denominacion + '\'' +
                ", fechaDesde=" + fechaDesde +
                ", fechaHasta=" + fechaHasta +
                ", descripcionDescuento='" + descripcionDescuento + '\'' +
                ", precioPromocional=" + precioPromocional +
                ", tipoPromocion=" + tipoPromocion +

                '}';
    }
}
