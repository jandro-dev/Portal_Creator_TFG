package portal.template.portaltemplatespring.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.exception.ResourceNotFoundException;
import portal.template.portaltemplatespring.models.dto.PortalDTO;
import portal.template.portaltemplatespring.models.entity.Categoria;
import portal.template.portaltemplatespring.models.entity.Portal;
import portal.template.portaltemplatespring.repository.CategoriaRepository;
import portal.template.portaltemplatespring.repository.PortalRepository;

@AllArgsConstructor
@Service
public class PortalService {

    private final PortalRepository portalRepository;
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper mapper;

    public Iterable<Portal> findAll() {
        return portalRepository.findAll();
    }

    public Portal findById(Integer categoriaId, Integer portalId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(ResourceNotFoundException::new);

        Portal portal = portalRepository.findById(portalId)
                .orElseThrow(ResourceNotFoundException::new);

        if (!portal.getCategoria().equals(categoria)) {
            throw new ResourceNotFoundException();
        }

        return portal;
    }

    public Portal crearPortal(Integer categoriaId, PortalDTO portalDTO, Categoria categoria) {
        Portal portal = mapper.map(portalDTO, Portal.class);
        portal.setCategoria(categoria);
        return portalRepository.save(portal);
    }

    public Portal actualizarPortal(Integer categoriaId, Integer portalId, PortalDTO portalDTO) {
        Portal portalBD = findById(categoriaId,portalId);

        mapper.map(portalDTO, portalBD);
        return portalRepository.save(portalBD);
    }

    public void borrarPortal(Integer categoriaId, Integer portalId) {
        Portal portalBD = findById(categoriaId,portalId);
        portalRepository.delete(portalBD);
    }

}
