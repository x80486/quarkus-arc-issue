package org.acme.persistence;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Optional;

/**
 * @author x80486
 */
@UseClasspathSqlLocator
interface GenericRepository<T, ID> {
  @SqlQuery("find_by_id")
  Optional<T> findById(@Bind("id") ID id);
}
