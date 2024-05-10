package portal.template.portaltemplatespring.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.exception.ResourceNotFoundException;
import portal.template.portaltemplatespring.models.dto.PerfilDTO;
import portal.template.portaltemplatespring.models.entity.Perfil;
import portal.template.portaltemplatespring.repository.PerfilRepository;

@AllArgsConstructor
@Service
public class PerfilService {
    
    private final PerfilRepository perfilRepository;
    private final ModelMapper mapper;

    public Perfil crearPerfil(PerfilDTO perfilDTO) {
        Perfil perfil = new Perfil();
        perfil.setNombre(perfilDTO.getNombre());
        perfil.setApellidos(perfilDTO.getApellidos());
        perfil.setColorWeb1(perfilDTO.getColorWeb1());
        perfil.setColorWeb2(perfilDTO.getColorWeb2());

        return perfilRepository.save(perfil);
    }

    public Perfil findById(Integer id) {
        return perfilRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Perfil actualizarPerfil(Integer id, PerfilDTO perfilDTO) {

        Perfil perfilBD = findById(id);

        mapper.map(perfilDTO, perfilBD);
        return perfilRepository.save(perfilBD);
    }

}
