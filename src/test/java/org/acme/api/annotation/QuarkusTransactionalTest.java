package org.acme.api.annotation;

import io.quarkus.test.junit.QuarkusTest;

import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author x80486
 */
@Stereotype
@QuarkusTest
@Transactional
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuarkusTransactionalTest {
  // ...
}
