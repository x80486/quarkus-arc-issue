package org.acme.config;

import org.acme.persistence.ActorRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

/**
 * @author x80486
 */
@ApplicationScoped
public class PersistenceConfig {
  @Inject
  DataSource dataSource;

  @Singleton
  public Jdbi jdbi() {
    return Jdbi.create(dataSource)
        .installPlugin(new SqlObjectPlugin());
  }

  //-----------------------------------------------------------------------------------------------
  //
  //-----------------------------------------------------------------------------------------------

  @Produces
  public ActorRepository actorRepository(final Jdbi jdbi) {
    return jdbi.onDemand(ActorRepository.class);
  }
}
