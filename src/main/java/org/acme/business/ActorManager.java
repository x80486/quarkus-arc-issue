package org.acme.business;

import org.acme.domain.Actor;
import org.acme.persistence.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

/**
 * @author x80486
 */
@Transactional
@ApplicationScoped
public class ActorManager {
  private static final Logger LOGGER = LoggerFactory.getLogger(ActorManager.class);

  @Inject
  ActorRepository repository;

  public Optional<Actor> findById(final UUID id) {
    LOGGER.debug("Searching for actor [{}]", id);
    return repository.findById(id);
  }
}
