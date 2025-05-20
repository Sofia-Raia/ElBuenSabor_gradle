package org.example.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Categoria {
    private String denominacion;
    @ToString.Exclude
    private Categoria categoriaPadre;
    private Set<Categoria> subCategorias ;

    private Set<Articulo>articulosDeLaCategoria;

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }


    public void addArticulo(Articulo articulo) {
        if (articulosDeLaCategoria == null) {
            articulosDeLaCategoria = new HashSet<Articulo>();
        }
        articulosDeLaCategoria.add(articulo);
    }
    public void removeArticulo(Articulo articulo) {
        this.articulosDeLaCategoria.remove(articulo);
    }

    /// --------------------------------------------------
    public void addSubCategoria(Categoria categoria) {
        if (subCategorias == null) {
            subCategorias = new HashSet<Categoria>();
        }
        subCategorias.add(categoria);
        categoria.setCategoriaPadre(this);
    }
    public void removeCategoria(Categoria categoria) {
        subCategorias.remove(categoria);
        categoria.setCategoriaPadre(null);
    }

    //solo muestro el nombre.
    @Override
    public String toString() {
        return "Categoria{ " +
                denominacion + '\'' +
                '}';
    }
}

