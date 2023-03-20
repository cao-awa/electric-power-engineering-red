package com.github.cao.awa.trtr.annotation.property;

import com.github.cao.awa.apricot.anntation.Auto;
import com.github.cao.awa.apricot.anntation.Stable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Auto
@Stable
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AutoProperty {
}
