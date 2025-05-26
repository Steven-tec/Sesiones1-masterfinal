package org.steven.prManejosdeSesiones.services;

import org.steven.prManejosdeSesiones.models.Productos;
import java.util.List;

public interface ProductoService {
    // Método para obtener la lista de productos
    List<Productos>listar();
}