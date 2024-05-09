package portal.template.portaltemplatespring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.models.dto.CategoriaDTO;
import portal.template.portaltemplatespring.models.dto.PortalDTO;
import portal.template.portaltemplatespring.models.entity.Categoria;
import portal.template.portaltemplatespring.models.entity.Portal;
import portal.template.portaltemplatespring.services.CategoriaService;
import portal.template.portaltemplatespring.services.PortalService;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/categorias")
@RestController
public class CategoriaPortalController {
    
    private final CategoriaService categoriaService;
    private final PortalService portalService;

    // CRUD PARA CATEGORIAS

    @GetMapping
    public Iterable<Categoria> listCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("{id}")
    public Categoria getCategoria(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Categoria createCategoria(@Validated @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.crearCategoria(categoriaDTO);
    }

    @PutMapping("{id}")
    public Categoria updateCategoria(@PathVariable Integer id, @Validated @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.actualizarCategoria(id, categoriaDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.borrarCategoria(id);
    }

    // CRUD PARA PORTALES DENTRO DE UNA CATEGORIA

    @GetMapping("{categoriaId}/portales")
    public List<Portal> listPortalesPorCategoria(@PathVariable Integer categoriaId) {
        Categoria categoria = categoriaService.findById(categoriaId);
        return categoria.getPortales();
    }

    @GetMapping("{categoriaId}/portales/{portalId}")
    public Portal getPortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId) {
        return portalService.findById(categoriaId, portalId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{categoriaId}/portales")
    public Portal createPortal(@PathVariable Integer categoriaId, @Validated @RequestBody PortalDTO portalDTO) {
        Categoria categoria = categoriaService.findById(categoriaId);
        return portalService.crearPortal(categoriaId, portalDTO, categoria);
    }

    @PutMapping("{categoriaId}/portales/{portalId}")
    public Portal updatePortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId,
            @Validated @RequestBody PortalDTO portalDTO) {
        return portalService.actualizarPortal(categoriaId, portalId, portalDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{categoriaId}/portales/{portalId}")
    public void deletePortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId) {
        portalService.borrarPortal(categoriaId, portalId);
    }

}
