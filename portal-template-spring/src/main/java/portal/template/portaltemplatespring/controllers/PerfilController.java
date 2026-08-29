package portal.template.portaltemplatespring.controllers;

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
import portal.template.portaltemplatespring.models.dto.PerfilDTO;
import portal.template.portaltemplatespring.models.entity.Perfil;
import portal.template.portaltemplatespring.services.PerfilService;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/perfil")
@RestController
public class PerfilController {
    
    private final PerfilService perfilService;

    @GetMapping("{id}")
    public Perfil getPerfil(@PathVariable Integer id) {
        return perfilService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Perfil createPerfil(@Validated @RequestBody PerfilDTO perfilDTO) {
        return perfilService.crearPerfil(perfilDTO);
    }

    @PutMapping("{id}")
    public Perfil updatePerfil(@PathVariable Integer id, @Validated @RequestBody PerfilDTO perfilDTO) {
        return perfilService.actualizarPerfil(id,perfilDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletePerfil(@PathVariable Integer id) {
        perfilService.borrarPerfil(id);
    }
    
}
