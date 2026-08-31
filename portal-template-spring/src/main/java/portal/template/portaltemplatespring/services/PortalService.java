package portal.template.portaltemplatespring.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.exception.ResourceNotFoundException;
import portal.template.portaltemplatespring.models.dto.PortalDTO;
import portal.template.portaltemplatespring.models.entity.Categoria;
import portal.template.portaltemplatespring.models.entity.Portal;
import portal.template.portaltemplatespring.repository.PortalRepository;

@AllArgsConstructor
@Service
public class PortalService {

    private final PortalRepository portalRepository;
    private final CategoriaService categoriaService;
    private final ModelMapper mapper;

    public Portal findById(Integer perfilId, Integer categoriaId, Integer portalId) {
        Categoria categoria = categoriaService.findByIdAndPerfilId(categoriaId, perfilId);

        Portal portal = portalRepository.findById(portalId)
                .orElseThrow(ResourceNotFoundException::new);

        if (portal.getCategoria() == null || !portal.getCategoria().getId().equals(categoria.getId())) {
            throw new ResourceNotFoundException();
        }

        return portal;
    }

    public List<Portal> findAllByCategoriaId(Integer categoriaId, Integer perfilId) {
        
        // Comprueba que la categoría pertenece al perfil
        Categoria categoria = categoriaService
            .findByIdAndPerfilId(categoriaId, perfilId);

        return portalRepository.findByCategoriaId(categoria.getId());
    }

    public Portal crearPortal(Integer perfilId, Integer categoriaId, PortalDTO portalDTO) {
        // Comprueba que la categoría pertenece al perfil
        Categoria categoria = categoriaService.findByIdAndPerfilId(categoriaId, perfilId);

        Portal portal = mapper.map(portalDTO, Portal.class);
        portal.setCategoria(categoria);
        return portalRepository.save(portal);
    }

    public Portal actualizarPortal(Integer perfilId,Integer categoriaId, Integer portalId, PortalDTO portalDTO) {
        Portal portalBD = findById(perfilId, categoriaId,portalId);

        mapper.map(portalDTO, portalBD);
        return portalRepository.save(portalBD);
    }

    public void borrarPortal(Integer perfilId, Integer categoriaId, Integer portalId) {
        Portal portalBD = findById(perfilId, categoriaId, portalId);
        portalRepository.delete(portalBD);
    }

}
