package portal.template.portaltemplatespring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Portal;

@Repository
public interface PortalRepository extends CrudRepository<Portal,Integer> {}