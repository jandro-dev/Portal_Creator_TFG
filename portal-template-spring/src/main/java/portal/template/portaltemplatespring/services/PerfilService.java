package portal.template.portaltemplatespring.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.models.entity.Perfil;
import portal.template.portaltemplatespring.repository.PerfilRepository;

@AllArgsConstructor
@Service
public class PerfilService {
    
    private final PerfilRepository perfilRepository;

    public Perfil crearPerfil(Perfil perfil) {
        perfil.setNombre(perfil.getNombre());
        perfil.setApellidos(perfil.getApellidos());
        perfil.setColorWeb1(perfil.getColorWeb1());
        perfil.setColorWeb2(perfil.getColorWeb2());

        return perfilRepository.save(perfil);
    }

}
