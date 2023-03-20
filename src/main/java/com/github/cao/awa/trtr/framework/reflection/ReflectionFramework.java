package com.github.cao.awa.trtr.framework.reflection;

import com.github.cao.awa.apricot.anntation.Auto;
import com.github.cao.awa.trtr.TrtrMod;
import com.github.cao.awa.trtr.annotation.dev.DevOnly;
import com.github.cao.awa.trtr.framework.accessor.method.MethodAccess;
import com.github.cao.awa.trtr.framework.exception.NoAutoAnnotationException;
import com.github.cao.awa.trtr.framework.loader.JarSearchLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public abstract class ReflectionFramework {
    private static final Logger LOGGER = LogManager.getLogger("Trtr/ReflectionFramework");
    private static final Reflections REFLECTIONS = new Reflections(new ConfigurationBuilder().addUrls(JarSearchLoader.load(new File("mods")))
                                                                                             .addUrls(ClasspathHelper.forPackage(""))
                                                                                             .addScanners(Scanners.TypesAnnotated));

    public Reflections getReflection() {
        return REFLECTIONS;
    }

    public boolean checkFields(String target, List<String> field) {
        if (field.size() > 0) {
            LOGGER.error("'{}' has missing required field(s): {}",
                         target,
                         field
            );
            return false;
        } else {
            LOGGER.debug("'{}' has passed checking required field(s)",
                         target
            );
            return true;
        }
    }

    public static boolean checkDev(Class<?> clazz) {
        return clazz != null && (! clazz.isAnnotationPresent(DevOnly.class) || TrtrMod.DEV_MODE);
    }

    public static boolean checkDev(Field field) {
        return field != null && (! field.isAnnotationPresent(DevOnly.class) || TrtrMod.DEV_MODE);
    }

    public static <T> Constructor<T> ensureAccessible(Constructor<T> clazz) {
        if (clazz.canAccess(null)) {
            return clazz;
        }
        clazz.trySetAccessible();
        return clazz;
    }

    @NotNull
    public static Method ensureAccessible(Method clazz) {
        if (clazz.getAnnotation(Auto.class) != null) {
            return MethodAccess.ensureAccessible(clazz);
        }
        throw new NoAutoAnnotationException();
    }

    public static Field ensureAccessible(@NotNull Field field) {
        return ensureAccessible(field,
                                null
        );
    }

    public static Field ensureAccessible(@NotNull Field field, @Nullable Object obj) {
        if (field.canAccess(Modifier.isStatic(field.getModifiers()) ? null : obj)) {
            return field;
        }
        field.trySetAccessible();
        return field;
    }
}
