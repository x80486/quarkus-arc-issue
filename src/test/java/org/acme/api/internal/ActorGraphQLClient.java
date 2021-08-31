package org.acme.api.internal;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import io.smallrye.mutiny.Uni;
import org.acme.domain.Actor;
import org.eclipse.microprofile.graphql.Query;

import java.util.UUID;

/**
 * @author x80486
 */
@GraphQLClientApi
public interface ActorGraphQLClient {
  @Query("getActor")
  Uni<Actor> findActor(UUID id);
}
