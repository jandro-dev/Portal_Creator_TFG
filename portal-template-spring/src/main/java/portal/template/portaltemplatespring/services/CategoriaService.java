package portal.template.portaltemplatespring.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import portal.template.portaltemplatespring.exception.ResourceNotFoundException;
import portal.template.portaltemplatespring.models.dto.CategoriaDTO;
import portal.template.portaltemplatespring.models.entity.Categoria;
import portal.template.portaltemplatespring.repository.CategoriaRepository;

@AllArgsConstructor
@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper mapper;

    public Iterable<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Categoria crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = mapper.map(categoriaDTO, Categoria.class);

        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Integer id, CategoriaDTO categoriaDTO) {
        Categoria categoriaBD = findById(id);

        mapper.map(categoriaDTO, categoriaBD);
        return categoriaRepository.save(categoriaBD);
    }

    public void borrarCategoria(Integer id) {
        Categoria categoriaBD = findById(id);
        categoriaRepository.delete(categoriaBD);
    }

}
