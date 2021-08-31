package org.acme.api;

import graphql.GraphqlErrorException;
import io.smallrye.graphql.api.Context;
import io.smallrye.mutiny.Uni;
import org.acme.business.ActorManager;
import org.acme.domain.Actor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

/**
 * @author x80486
 */
@GraphQLApi
@ApplicationScoped
public final class ActorResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(ActorResource.class);

  @Inject
  ActorManager service;

  @Query("getActor")
  @Description("Fetch an actor")
  public Uni<Actor> getActor(@Name("id") final UUID id, final Context context) {
    LOGGER.info("Retrieving actor [{}]", id);
    final var result = service.findById(id)
        .orElseThrow(() -> GraphqlErrorException.newErrorException()
            .message("Your time is very important to us. Please wait while we ignore you...")
            .build());
    return Uni.createFrom().item(result);
  }
}
