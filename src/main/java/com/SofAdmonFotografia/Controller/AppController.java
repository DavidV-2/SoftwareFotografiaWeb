package com.SofAdmonFotografia.Controller;

import com.SofAdmonFotografia.model.*;
import com.SofAdmonFotografia.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @Autowired
    private IProductoServicio productoServicio;

    @Autowired
    private IVentasServicio ventasServicio;

    @Autowired
    private IEventosServicio eventosServicio;

    /*-------------MENU VENTAS-------------*/
    @GetMapping("/ventas")
    public String registroVenta(Model model) {
        model.addAttribute("ventas", new Ventas());
        return "ventas/index"; // Esta vista debe existir en la carpeta templates/eventos/
    }
    /*-------------FORMULARIO EVENTOS REGISTRO-------------*/
    @PostMapping("/ventas")
    public String registroVenta(@ModelAttribute("ventas") Ventas ventas, Model model) {
        try {
            ventasServicio.SP_RegistroVenta(
                    ventas.getDatosCliente(),
                    ventas.getDetalleProducto(),
                    ventas.getEspecificaciones(),
                    ventas.getTelefono(),
                    ventas.getValorVenta(),
                    ventas.getValorAbono(),
                    ventas.getValorResta(),
                    ventas.getEstadoDeuda(),
                    ventas.getTransferencia()
            );
            model.addAttribute("success", "Venta registrada exitosamente.");
            return "redirect:/registro";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al registrar Venta: " + e.getMessage());
            return "ventas/index";
        }
    }

    /*-------------MENU DETALLE VENTAS-------------*/
    // Mapeo para ver el detalle de ventas
    @GetMapping("/ventas/lista")
    public String detalleventas(Model model) {
        List<Ventas> ventas = ventasServicio.listarVentas(); // Obtener lista de detalles de ventas
        model.addAttribute("ventas", ventas); // Añadir la lista al modelo para la vista
        return "ventas/lista"; // Devuelve la vista correspondiente
    }

    /*-------------MENU LISTADO EVENTOS-------------*/
    // Mapeo para listar eventos
    @GetMapping("/eventos")
    public String mostrarEventos(Model model) {
        List<Evento> eventos = eventosServicio.listarEventos(); // Obtener lista de eventos
        model.addAttribute("eventos", eventos); // Añadir eventos al modelo
        return "eventos/index"; // Vista de lista de eventos
    }

    /*-------------MENU EVENTOS REGISTRO-------------*/
    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("eventos", new Evento());
        return "eventos/registro";
    }

    /*-------------FORMULARIO EVENTOS REGISTRO-------------*/

    @PostMapping("/registro")
    public String registrarEvento(@ModelAttribute("eventos") Evento evento, Model model) {
        try {
            eventosServicio.SP_RegistrarEvento(
                    evento.getNombreCliente(),
                    evento.getTelefono(),
                    evento.getFechaEvento(),
                    evento.getCodigo(),
                    evento.getDetalleEvento(),
                    evento.getDireccion(),
                    evento.getEstadoDeuda()
            );
            model.addAttribute("success", "Evento registrado exitosamente.");
            return "redirect:/registro";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al registrar el evento: " + e.getMessage());
            return "eventos/registro";
        }
    }

    /*-------------MENU PRODUCTOS-------------*/
    // Mapeo para mostrar productos
    @GetMapping("/productos")
    public String mostrarProductos(
            @RequestParam(value = "name", required = false) String codigo,
            Model model
    ) {
        List<Producto> productos;
        // Buscar productos por código o listar todos los productos
        if (codigo != null && !codigo.isEmpty()) {
            productos = productoServicio.SP_BuscarProductos(1, codigo, null);
        } else {
            productos = productoServicio.listarProductos();
        }
        model.addAttribute("productos", productos); // Añadir productos al modelo
        return "productos/index"; // Devolver vista de productos
    }

    /*-------------MENU USUARIOS-------------*/

    // Mapeo para mostrar usuarios
    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios(); // Obtener lista de usuarios
        model.addAttribute("usuarios", usuarios); // Añadir usuarios al modelo
        return "usuarios/index"; // Devolver vista de usuarios
    }
}