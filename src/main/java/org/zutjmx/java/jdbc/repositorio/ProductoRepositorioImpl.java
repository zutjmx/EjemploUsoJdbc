package org.zutjmx.java.jdbc.repositorio;

import org.zutjmx.java.jdbc.modelo.Producto;
import org.zutjmx.java.jdbc.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
    private static String consultaSqlTodos = "SELECT * FROM productos";
    private static String consultaSqlById = consultaSqlTodos.concat(" WHERE id = ?");

    private Connection getConexion() throws SQLException {
        return ConexionBD.getConnection();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try(Statement statement = getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSqlTodos)) {
            while (resultSet.next()) {
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try(PreparedStatement preparedStatement = getConexion().prepareStatement(consultaSqlById)) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                producto = crearProducto(resultSet);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    private Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getInt("precio"));
        producto.setFechaCreacion(resultSet.getDate("fecha_registro"));
        return producto;
    }

}
