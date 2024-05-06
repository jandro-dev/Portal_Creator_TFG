package portal.template.portaltemplatespring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import portal.template.portaltemplatespring.models.dao.CategoriaRepository;
import portal.template.portaltemplatespring.models.entity.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CategoriaController {
    
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository _categoriaRepository) {
        this.categoriaRepository = _categoriaRepository;
    }

    @GetMapping("/category")
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @PostMapping("/category")
    void addCategoria(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
    }
    
    // Faltan los metodos para editar y borrar una categoria

}
