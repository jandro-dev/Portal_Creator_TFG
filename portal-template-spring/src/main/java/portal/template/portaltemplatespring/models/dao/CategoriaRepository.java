package portal.template.portaltemplatespring.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long> {}