package portal.template.portaltemplatespring.models.dao;

import org.springframework.data.repository.CrudRepository;

import portal.template.portaltemplatespring.models.entity.Categoria;

public interface ICategoria extends CrudRepository<Categoria,Long> {}