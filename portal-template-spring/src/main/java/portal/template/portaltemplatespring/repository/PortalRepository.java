package portal.template.portaltemplatespring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Portal;

@Repository
public interface PortalRepository extends CrudRepository<Portal,Integer> {

	 List<Portal> findByCategoriaId(Integer categoriaId);


}