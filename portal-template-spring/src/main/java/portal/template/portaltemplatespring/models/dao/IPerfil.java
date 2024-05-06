package portal.template.portaltemplatespring.models.dao;

import org.springframework.data.repository.CrudRepository;

import portal.template.portaltemplatespring.models.entity.Perfil;

public interface IPerfil extends CrudRepository<Perfil,Long> {}