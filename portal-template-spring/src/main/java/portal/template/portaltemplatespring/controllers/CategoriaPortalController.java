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
import org.springframework.web.bind.annotation.RequestParam;
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
    public Iterable<Categoria> listCategorias(@RequestParam Integer perfilId) {
        return categoriaService.findAllByPerfilId(perfilId);
    }

    @GetMapping("{id}")
    public Categoria getCategoria(@PathVariable Integer id, @RequestParam Integer perfilId) {
        return categoriaService.findByIdAndPerfilId(id, perfilId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Categoria createCategoria(@RequestParam Integer perfilId, @Validated @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.crearCategoria(perfilId, categoriaDTO);
    }

    @PutMapping("{id}")
    public Categoria updateCategoria(@PathVariable Integer id,@RequestParam Integer perfilId, @Validated @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.actualizarCategoria(id, perfilId, categoriaDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteCategoria(@PathVariable Integer id, @RequestParam Integer perfilId) {
        categoriaService.borrarCategoria(id, perfilId);
    }

    // CRUD PARA PORTALES DENTRO DE UNA CATEGORIA

    @GetMapping("/{categoriaId}/portales")
    public List<Portal> listPortalesPorCategoria(@PathVariable Integer categoriaId, @RequestParam Integer perfilId) {

        return portalService.findAllByCategoriaId(categoriaId, perfilId);
    }    

    @GetMapping("{categoriaId}/portales/{portalId}")
    public Portal getPortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId, @RequestParam Integer perfilId) {
        return portalService.findById(perfilId, categoriaId, portalId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{categoriaId}/portales")
    public Portal createPortal(@PathVariable Integer categoriaId, @RequestParam Integer perfilId, @Validated @RequestBody PortalDTO portalDTO) {
        return portalService.crearPortal(perfilId, categoriaId, portalDTO);
    }

    @PutMapping("{categoriaId}/portales/{portalId}")
    public Portal updatePortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId, @RequestParam Integer perfilId,
            @Validated @RequestBody PortalDTO portalDTO) {
        return portalService.actualizarPortal(perfilId, categoriaId, portalId, portalDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{categoriaId}/portales/{portalId}")
    public void deletePortal(@PathVariable Integer categoriaId, @PathVariable Integer portalId, @RequestParam Integer perfilId) {
        portalService.borrarPortal(perfilId, categoriaId, portalId);
    }

}
