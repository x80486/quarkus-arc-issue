package org.acme.business;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.domain.internal.ActorFactory;
import org.acme.persistence.ActorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

/**
 * @author x80486
 */
@QuarkusTest
final class ActorManagerTest {
  @InjectMock
  ActorRepository repository;

  @Inject
  ActorManager service;

  @Test
  void findById_WhenActorDoesNotExist() {
    final var id = UUID.fromString("c6b1d415-77ee-49c2-b912-fbd00e07702b");
    Mockito.when(repository.findById(id)).thenReturn(Optional.empty());
    Assertions.assertThat(service.findById(id)).isNotPresent();
  }

  @Test
  void findById_WhenActorExist() {
    final var id = UUID.fromString("3bea7318-bb7a-4232-9343-59579dd5b2a2"); // Penelope Guiness
    final var expected = ActorFactory.penelopeGuiness();
    Mockito.when(repository.findById(id)).thenReturn(Optional.of(expected));
    Assertions.assertThat(service.findById(id)).contains(expected);
  }
}
