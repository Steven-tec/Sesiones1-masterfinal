package org.steven.prManejosdeSesiones.repository;

import org.steven.prManejosdeSesiones.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryJdbcImplement implements Repository<Categoria> {

    //creamos una variable donde vamos a guardar la conexion a la base de datos
    private Connection conn;
    public CategoriaRepositoryJdbcImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categoria")) {
            while (rs.next()) {
                Categoria c = getCategoria(rs);
                categorias.add(c);
            }
            return categorias;
        }
    }


    @Override
    public Categoria porId(int id) throws SQLException {
        //creo un objeto de tipo categoria
        Categoria categoria = new Categoria();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categoria where id = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                categoria = getCategoria(rs);
            }
        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        //declaro uan variable de tipo string
        String sql;
        if (categoria.getIdCategoria() > 0) {
            sql="update categoria set nombre = ?, descripcion=? where idCategoria = ?";

        }else {
            sql="insert into categoria (nombre, descripcion, condicion) values (?,?,1)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setInt(3, categoria.getIdCategoria());
            stmt.executeUpdate();

        }


    }

    @Override
    public void eliminar(int id) throws SQLException {

    }

    private static Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();

        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setCondicion(rs.getInt("condicion"));
        c.setIdCategoria(rs.getInt("idCategoria"));
        return c;
    }

}
