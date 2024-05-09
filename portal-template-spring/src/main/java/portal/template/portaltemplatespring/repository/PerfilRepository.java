package portal.template.portaltemplatespring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil,Integer> {}