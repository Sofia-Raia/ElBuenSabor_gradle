package org.example;

import org.example.configuracion.DatabaseConnection;
import org.example.entidades.*;
import org.example.enumerables.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Setup pais - provincias - localidades
        // Argentina
        Pais arg = new Pais("Argentina");
        Provincia mdz = new Provincia("Mendoza");
        mdz.setPais(arg);
        Localidad sexta = new Localidad("Sexta Seccion");
        sexta.setProvincia(mdz);
        Provincia sj = new Provincia("San Juan");
        sj.setPais(arg);
        Localidad locSj = new Localidad("Localidad de sanjuan");
        locSj.setProvincia(sj);
        // Chile
        Pais chile = new Pais("Chile");
        Provincia sant = new Provincia("Santiago de Chile");
        sant.setPais(chile);
        Localidad locSant = new Localidad("Localidad de Santiago de Chile");
        locSant.setProvincia(sant);
        Provincia valp = new Provincia("Valparaiso");
        valp.setPais(chile);
        Localidad locValp = new Localidad("Localidad de Valparaiso");
        locValp.setProvincia(valp);

        // Setup Articulos - UnidadMedida - Detalle
        UnidadMedida pequeno = new UnidadMedida("6 porciones");
        UnidadMedida mediano = new UnidadMedida("8 porciones");
        UnidadMedida grande = new UnidadMedida("12 porciones");
        UnidadMedida kg = new UnidadMedida("Kg");
        ArticuloInsumo harina = new ArticuloInsumo("Harina 000", 49.99, kg, 20.0);
        ArticuloInsumo levadura = new ArticuloInsumo("Levadura", 9.99, kg, 5.0);
        ArticuloManufacturadoDetalle amd1 = new ArticuloManufacturadoDetalle(1, harina);
        ArticuloManufacturado am1 = new ArticuloManufacturado("Pizza",20000.00, pequeno,"Pizza Napolitana");
        am1.addDetalle(amd1);
        ArticuloManufacturadoDetalle amd2 = new ArticuloManufacturadoDetalle(2, levadura);
        ArticuloManufacturado am2 = new ArticuloManufacturado("Pizza",22000.00, pequeno,"Pizza Calabresa");
        am2.addDetalle(amd2);
        ImagenComida img1 = new ImagenComida("promo1imagen1.jpg");
        ImagenComida img2 = new ImagenComida("promo1imagen2.jpg");
        Promocion promo1 = new Promocion("San Juan");
        promo1.setFechaDesde(LocalDate.parse("2025-05-18"));
        promo1.setHoraDesde(LocalTime.parse("00:00"));
        promo1.setFechaHasta(LocalDate.parse("2026-05-18"));
        promo1.setHoraHasta(LocalTime.parse("23:59"));
        promo1.setDescripcionDescuento("HotSale");
        promo1.setPrecioPromocional(0.8);
        promo1.setTipoPromocion(TipoPromocion.PROMOCION1);
        promo1.addImagen(img1);
        promo1.addImagen(img2);
        promo1.addArticulo(am1);

        Promocion promo2 = new Promocion("Promo del día");
        //doble vinculacion de categorias
        Categoria cat1 = new Categoria("Pastas");
        Categoria subC1 = new Categoria("Pizzas");
        Categoria subc2= new Categoria("Sorrentinos");
        Categoria subc3= new Categoria("Añelotis");
        Categoria subc4= new Categoria("Rabioles");
        cat1.addSubCategoria(subC1);
        cat1.addSubCategoria(subc2);
        cat1.addSubCategoria(subc3);
        cat1.addSubCategoria(subc4);

        //________________________
        Categoria cat2 = new Categoria("Postres");
        Categoria subC5 = new Categoria("Helado");
        cat2.addSubCategoria(subC5);

        Categoria cat3 = new Categoria("Bebidas");

        Sucursal s1 = new Sucursal("sucursal 1");
        Domicilio domS1 = new Domicilio("calle 1", 100, 1000);
        domS1.setLocalidad(sexta);
        s1.setDomicilio(domS1);
        s1.addCategoria(cat1);
        s1.addCategoria(cat2);

        Sucursal s2 = new Sucursal("sucursal 2");
        Domicilio domS2 = new Domicilio("calle 2", 65, 9000);
        domS2.setLocalidad(locSj);
        s2.setDomicilio(domS2);
        s2.addCategoria(cat1);
        s2.addCategoria(cat2);
        s2.addCategoria(cat3);

        DetallePedido detallePedido = new DetallePedido(am1,1);
        Factura factura1= new Factura(LocalDate.now(), 22000.00);
        Pedido p1 =new Pedido(20000.00);
        p1.addDetallePedido(detallePedido);
        p1.setFactura(factura1);

        DetallePedido detallePedido1 = new DetallePedido(am2,1);
        Factura factura2= new Factura(LocalDate.now(), 22000.00);
        Pedido p2 =new Pedido(22000.00);
        p2.addDetallePedido(detallePedido1);
        p2.setFactura(factura2);

        Empresa e1 = new Empresa("Bonitos y Gorditos S.A.", 1);
        e1.addSucursal(s1);
        e1.addSucursal(s2);

        Usuario u1=new Usuario();
        Usuario u2=new Usuario();
        Usuario u3=new Usuario();
        Usuario u4=new Usuario();
        Cliente c1 = new Cliente("Sofia", "Raia", "232323445", "sofia@gmail.com");
        Cliente c2 = new Cliente("Nahomi", "Rosas", "23232663445", "Nahomi@gmail.com");
        Cliente c3 = new Cliente("Celeste", "Rinaldi", "23232344511", "Celeste@gmail.com");
        Cliente c4 = new Cliente("Maria", "Rodriguez", "1552323445", "Maria@gmail.com");
        c1.setUsuario(u1);
        c2.setUsuario(u2);
        c3.setUsuario(u3);
        c4.setUsuario(u4);

        e1.setRazonSocial("SA");
        System.out.println(e1);

        p1.setHoraEstimadaFinalizacion(LocalTime.of(14, 30));
        p1.setTotal(22000.00);
        p1.setTotalCosto(25000.00);
        p1.setFechaPedido(LocalDate.now());
        p1.addDetallePedido(detallePedido1);
        p1.setSucursal(s1);
        p1.setDomicilio(domS1);

        System.out.println(p1);
        promo2.setTipoPromocion(TipoPromocion.PROMOCION1);
        promo2.setFechaDesde(LocalDate.now());
        promo2.setFechaHasta(LocalDate.now());
        promo2.setPrecioPromocional(20000.00);
        promo2.setDescripcionDescuento("Bebida gratis");
        promo2.setTipoPromocion(TipoPromocion.HAPPYHOUR);
        System.out.println(promo2);
       Empresa em= Empresa.builder()
                .nombre("sl.sofi")
                .build();





//esto es lo que iba en la clase main_testConnection de coneccion a Base de Datos
/*
        try(Connection conn = DatabaseConnection.obtenerConexion();){
            if(conn!=null){
                String nombreGuardar = "Sofia";
                String query = "INSERT INTO persona (nombre) VALUES (?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query);){
                    pstmt.setString(1, nombreGuardar);
                    pstmt.executeUpdate();
                }

                String query2 = "SELECT id,nombre FROM persona";
                try(PreparedStatement pstmt = conn.prepareStatement(query2);
                    ResultSet rs = pstmt.executeQuery();){
                    while (rs.next()){
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        System.out.println("ID " + id + " | Nombre: " + nombre);
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println("Error de base de datos: " + ex.getMessage());
        }

         */
    }
}
