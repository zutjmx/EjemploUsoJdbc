package org.zutjmx.java.jdbc;

import org.zutjmx.java.jdbc.modelo.Producto;
import org.zutjmx.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.zutjmx.java.jdbc.repositorio.Repositorio;
import org.zutjmx.java.jdbc.util.ConexionBD;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try(Connection connection = ConexionBD.getConnection()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println("Se prueba el método lista():");
            repositorio.listar().forEach(System.out::println);

            System.out.println("Se prueba el método porId():");
            System.out.println(repositorio.porId(2L));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
