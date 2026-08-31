package portal.template.portaltemplatespring.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.exception.ResourceNotFoundException;
import portal.template.portaltemplatespring.models.dto.CategoriaDTO;
import portal.template.portaltemplatespring.models.entity.Categoria;
import portal.template.portaltemplatespring.models.entity.Perfil;
import portal.template.portaltemplatespring.repository.CategoriaRepository;
import portal.template.portaltemplatespring.repository.PerfilRepository;

@AllArgsConstructor
@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    private final PerfilRepository perfilRepository;
    private final ModelMapper mapper;


    // Todas las categorias de un perfil
    public Iterable<Categoria> findAllByPerfilId(Integer perfilId) {
        comprobarPerfil(perfilId);

        return categoriaRepository.findByPerfilId(perfilId);
    }

    // Buscar una categoria por id
    public Categoria findById(Integer id) {
        return categoriaRepository
            .findById(id)
            .orElseThrow(ResourceNotFoundException::new);
    }

    // Una categoria de un perfil
    public Categoria findByIdAndPerfilId(Integer categoriaId, Integer perfilId) {
        return categoriaRepository
                .findByIdAndPerfilId(categoriaId, perfilId)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Categoria crearCategoria(Integer perfilId, CategoriaDTO categoriaDTO) {
        Perfil perfil = comprobarPerfil(perfilId);
        
        Categoria categoria = mapper.map(categoriaDTO, Categoria.class);
        categoria.setPerfil(perfil);

        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Integer categoriaId, Integer perfilId, CategoriaDTO categoriaDTO) {
        Categoria categoriaBD = findByIdAndPerfilId(categoriaId, perfilId);

        mapper.map(categoriaDTO, categoriaBD);
        return categoriaRepository.save(categoriaBD);
    }

    public void borrarCategoria(Integer categoriaId, Integer perfilId) {
        Categoria categoriaBD = findByIdAndPerfilId(categoriaId, perfilId);
        categoriaRepository.delete(categoriaBD);
    }

    private Perfil comprobarPerfil(Integer perfilId) {
        return perfilRepository
                .findById(perfilId)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
