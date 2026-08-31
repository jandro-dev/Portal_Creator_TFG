package portal.template.portaltemplatespring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {
		
		Iterable<Categoria> findByPerfilId(Integer perfilId);

    Optional<Categoria> findByIdAndPerfilId(
            Integer categoriaId,
            Integer perfilId
    );

}