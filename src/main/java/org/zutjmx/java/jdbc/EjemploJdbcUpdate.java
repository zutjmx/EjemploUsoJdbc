package org.zutjmx.java.jdbc;

import org.zutjmx.java.jdbc.modelo.Producto;
import org.zutjmx.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.zutjmx.java.jdbc.repositorio.Repositorio;
import org.zutjmx.java.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try(Connection connection = ConexionBD.getConnection()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println(":::: Se prueba el método lista() ::::");
            repositorio.listar().forEach(System.out::println);

            System.out.println(":::: Se prueba el método porId() ::::");
            System.out.println(repositorio.porId(2L));

            System.out.println(":::: Se prueba el método guardar() con update ::::");
            Producto nuevoProducto = new Producto();
            nuevoProducto.setId(6L);
            nuevoProducto.setNombre("Huawei Y9A Edición Especial");
            nuevoProducto.setPrecio(8000);
            repositorio.guardar(nuevoProducto);

            System.out.println(":::: Producto actualizado ::::");

            System.out.println(":::: Lista de productos ::::");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
