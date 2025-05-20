package org.example.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class ArticuloManufacturado extends Articulo {
        private String descripcion;
        private Integer tiempoEstimadoMinutos;
        private String preparacion;
        private Set<ArticuloManufacturadoDetalle> aMd;

        public ArticuloManufacturado(String denominacion, Double precioVenta, UnidadMedida unidadMedida, String descripcion) {
            super(denominacion, precioVenta, unidadMedida);
            this.descripcion = descripcion;
        }


        public void addDetalle(ArticuloManufacturadoDetalle det) {
            if (this.aMd == null) {
                this.aMd = new HashSet<ArticuloManufacturadoDetalle>();
            }
            this.aMd.add(det);
        }
        public void removeDetalle(ArticuloManufacturadoDetalle det) {
            this.aMd.remove(det);
        }
        //no muestra preparacion ni detalle.
        @Override
        public String toString() {
            return "ArticuloManufacturado{" +
                    "descripcion='" + descripcion + '\'' +
                    ", tiempoEstimadoMinutos=" + tiempoEstimadoMinutos +
                    '}';
        }
    }

