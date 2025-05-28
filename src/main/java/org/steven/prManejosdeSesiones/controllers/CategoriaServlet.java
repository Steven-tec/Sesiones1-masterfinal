package org.steven.prManejosdeSesiones.controllers;

import org.steven.prManejosdeSesiones.models.Categoria;
import org.steven.prManejosdeSesiones.repository.CategoriaRepositoryJdbcImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/categorias")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/tu_basedatos", "usuario", "contraseña"
            );

            CategoriaRepositoryJdbcImplement repo = new CategoriaRepositoryJdbcImplement(conn);
            List<Categoria> categorias = repo.listar();

            request.setAttribute("categorias", categorias);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al listar categorías", e);
        }
    }
}