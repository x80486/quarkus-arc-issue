package org.acme.api;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.api.internal.ActorGraphQLClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.UUID;

/**
 * @author x80486
 */
@QuarkusTest
final class ActorResourceTest {
  @Inject
  ActorGraphQLClient client;

  @Test
  void getActor() {
    client.findActor(UUID.randomUUID());
  }
}
