package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Producto;
import com.example.demo.persistence.dao.ProductoDAO;
import com.example.demo.persistence.dao.impl.ProductoDAOImplHibernate;
import com.google.gson.Gson;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ProductoController {

 ProductoDAO productoDAO;
    Gson gson;

    public ProductoController() {

        productoDAO = new ProductoDAOImplHibernate();
        gson = new Gson();
    }

    @GetMapping("/Productos")
    public List<Producto> findAll() throws BusinessException {
    List<Producto> productos;

    productos=productoDAO.findAll();

    return productos;
 }

    @GetMapping("/Productos/{id}")
    public Producto get(@PathVariable Integer id) throws BusinessException {
        Producto producto;

        producto= (Producto) productoDAO.get(id);

        return producto;
    }

    @DeleteMapping("/Productos/{id}")
    public boolean delete(@PathVariable Integer id) throws BusinessException {
     boolean response = false;
     if(id!=null) {
         productoDAO.delete(id);
         response = true;

     }
     return response;
    }

    @GetMapping("/BuscarProductos/{id}")
    public List<Producto> findProducts(@PathVariable Integer id) throws BusinessException {
        List<Producto> productos;

        productos=productoDAO.findProducts(id);

        return productos;
    }

    @PostMapping("/MisProductos")
    public List<Producto> myProducts(@RequestBody String id) throws  BusinessException {
        List<Producto> productos;

        productos= productoDAO.myProducts(id);

        return productos;
    }

    @DeleteMapping("/Miproducto/{idProducto}/{idPropietario}")
    public boolean deleteMyProduct(@PathVariable  Integer idProducto,@PathVariable Integer idPropietario) throws BusinessException {
        boolean response = false;

        if(idProducto != null && idPropietario != null){
            productoDAO.deleteMyProduct(idProducto,idPropietario);
            response = true;
        }
        return response;
    }

    @GetMapping("/Miproducto/{idProducto}/{idPropietario}")
    public Producto getMyProduct(@PathVariable  Integer idProducto,@PathVariable Integer idPropietario) throws BusinessException {
        boolean response = false;
        Producto producto = new Producto();
        if(idProducto != null && idPropietario != null){
            producto= (Producto) productoDAO.getMyProduct(idProducto,idPropietario);

        }
        return producto;
    }

    @PutMapping("/Miproducto/{idProducto}/{visible}")
    public Producto updateVisible(@PathVariable Integer idProducto,@PathVariable String visible) throws BusinessException{
        Producto producto= null;
        if(idProducto!=null && visible != null){
            producto= (Producto) productoDAO.get(idProducto);

            //if(producto.getVisible().equals("0")) {
            //  producto.setVisible("1");
            //}else{
             //   producto.setVisible("0");
            //}
            producto.setVisible(visible);



            productoDAO.update(producto);

        }
        return producto;

    }

    @GetMapping("/ProductoVisible/{idPropietario}")
    public List<Producto> products (@PathVariable Integer idPropietario){
        List<Producto> products= null;
        if(idPropietario !=null){
            products = productoDAO.getProductVisible(idPropietario);
        }
        return products;
    }


}
