package portal.template.portaltemplatespring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import portal.template.portaltemplatespring.models.dao.PortalRepository;
import portal.template.portaltemplatespring.models.entity.Portal;

@RestController
public class PortalController {
    
    private PortalRepository portalRepository;

    public PortalController(PortalRepository _portalRepository) {
        this.portalRepository = _portalRepository;
    }

    @GetMapping("/portal")
    public List<Portal> getPortals() {
        return (List<Portal>) portalRepository.findAll();
    }

    @PostMapping("/portal")
    void addPortal(@RequestBody Portal portal) {
        portalRepository.save(portal);
    }
    
    // Faltan los metodos para editar y borrar un portal
}
