package org.acme.persistence;

import org.acme.domain.Actor;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

import java.util.UUID;

/**
 * @author x80486
 */
@RegisterBeanMapper(Actor.class)
public interface ActorRepository extends GenericRepository<Actor, UUID> {
  // ...
}
