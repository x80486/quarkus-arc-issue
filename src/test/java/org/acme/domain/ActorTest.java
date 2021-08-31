package org.acme.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

/**
 * @author x80486
 */
final class ActorTest {
  @Test
  void defaultInstance() {
    Assertions.assertThat(new Actor()).hasAllNullFieldsOrProperties();
  }

  @Test
  void properInstance() {
    final var id = UUID.randomUUID();
    final var rightNow = Instant.now();
    final var record = new Actor(id, "first", "last");
    record.setUpdatedAt(rightNow);
    Assertions.assertThat(record)
        .hasNoNullFieldsOrProperties()
        .satisfies(it -> {
          Assertions.assertThat(it.getId()).isEqualTo(id);
          Assertions.assertThat(it.getFirstName()).isEqualTo("first");
          Assertions.assertThat(it.getLastName()).isEqualTo("last");
          // ...
          Assertions.assertThat(it.getUpdatedAt()).isBetween(rightNow, Instant.now());
        });
  }

  @Test
  void verifyHashCodeEqualsContract() {
    EqualsVerifier.simple()
        .forClass(Actor.class)
        .withIgnoredFields("updatedAt")
        .verify();
  }
}
