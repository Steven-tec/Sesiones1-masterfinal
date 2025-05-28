package org.steven.prManejosdeSesiones.repository;

import java.sql.SQLException;
import java.util.List;

//<T> es un parametro genérico que permite definir cualquier tipo de objeto entidad que se desee manejar
public interface Repository <T>{

    List<T> listar() throws SQLException;
    T porId(int id) throws SQLException;
    void guardar(T t) throws SQLException;
    void eliminar(int id) throws SQLException;
}
