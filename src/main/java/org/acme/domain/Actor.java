package org.acme.domain;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * @author x80486
 */
public final class Actor {
  // @GraphQLQuery(name = "_id")
  @ColumnName("id") // ...used when class members differ from the database column identifiers
  private UUID id;

  private String firstName;

  private String lastName;

  private Instant updatedAt;

  public Actor() { }

  public Actor(final UUID id, final String firstName, final String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UUID getId() { return id; }
  public void setId(final UUID id) { this.id = id; }

  public String getFirstName() { return firstName; }
  public void setFirstName(final String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }
  public void setLastName(final String lastName) { this.lastName = lastName; }

  public Instant getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(final Instant updatedAt) { this.updatedAt = updatedAt; }

  //-----------------------------------------------------------------------------------------------
  //
  //-----------------------------------------------------------------------------------------------

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) { return true; }
    if (obj == null || getClass() != obj.getClass()) { return false; }
    final Actor actor = (Actor) obj;
    return Objects.equals(id, actor.id) &&
        Objects.equals(firstName, actor.firstName) &&
        Objects.equals(lastName, actor.lastName);
  }
}
