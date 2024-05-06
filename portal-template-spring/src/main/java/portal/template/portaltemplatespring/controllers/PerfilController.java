package portal.template.portaltemplatespring.controllers;

import org.springframework.web.bind.annotation.RestController;

import portal.template.portaltemplatespring.models.dao.PerfilRepository;
import portal.template.portaltemplatespring.models.entity.Perfil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PerfilController {
    
    private PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository _perfilRepository) {
        this.perfilRepository = _perfilRepository;
    }

    @PostMapping("/profile")
    void savePerfil(@RequestBody Perfil perfil) {
        perfilRepository.save(perfil);
    }
    

}
