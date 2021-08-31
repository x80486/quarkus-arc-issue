package org.acme.domain.internal;

import org.acme.domain.Actor;

import java.util.UUID;

/**
 * @author x80486
 */
public final class ActorFactory {
  private ActorFactory() { }

  public static Actor penelopeGuiness() {
    return new Actor(UUID.fromString("3bea7318-bb7a-4232-9343-59579dd5b2a2"), "Penelope", "Guiness");
  }
}
