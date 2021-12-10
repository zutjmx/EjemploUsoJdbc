package org.zutjmx.java.jdbc;

import org.zutjmx.java.jdbc.modelo.Producto;
import org.zutjmx.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.zutjmx.java.jdbc.repositorio.Repositorio;
import org.zutjmx.java.jdbc.util.ConexionBD;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try(Connection connection = ConexionBD.getConnection()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println(":::: Se prueba el método lista() ::::");
            repositorio.listar().forEach(System.out::println);

            System.out.println(":::: Se prueba el método porId() ::::");
            System.out.println(repositorio.porId(2L));

            System.out.println(":::: Se prueba el método guardar() ::::");
            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombre("Huawei Y9a");
            nuevoProducto.setPrecio(6000);
            nuevoProducto.setFechaCreacion(new Date());
            repositorio.guardar(nuevoProducto);

            System.out.println(":::: Producto guardado ::::");

            System.out.println(":::: Lista de productos ::::");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
