package org.acme.persistence;

import org.acme.api.annotation.QuarkusTransactionalTest;
import org.acme.domain.internal.ActorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.UUID;

/**
 * @author x80486
 */
@QuarkusTransactionalTest
final class ActorRepositoryTest {
  @Inject
  ActorRepository repository;

  @Test
  void findById_WhenActorDoesNotExist() {
    Assertions.assertThat(repository.findById(UUID.fromString("c6b1d415-77ee-49c2-b912-fbd00e07702b"))).isNotPresent();
  }

  @Test
  void findById_WhenActorExist() {
    Assertions.assertThat(repository.findById(UUID.fromString("3bea7318-bb7a-4232-9343-59579dd5b2a2")))
        .contains(ActorFactory.penelopeGuiness());
  }
}
