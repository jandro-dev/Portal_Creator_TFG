package portal.template.portaltemplatespring.models.dao;

import org.springframework.data.repository.CrudRepository;

import portal.template.portaltemplatespring.models.entity.Portal;

public interface IPortal extends CrudRepository<Portal,Long> {}