package portal.template.portaltemplatespring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.models.entity.Perfil;
import portal.template.portaltemplatespring.services.PerfilService;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/perfil")
@RestController
public class PerfilController {
    
    private final PerfilService perfilService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Perfil createPerfil(@Validated @RequestBody Perfil perfil) {
        return perfilService.crearPerfil(perfil);
    }
    

}
