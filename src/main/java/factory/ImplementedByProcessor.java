package factory;

import elements.Element;
import elements.ImplementedBy;

/**
 * Processes the iFace type into a useful class reference for wrapping WebElements.
 */
public final class ImplementedByProcessor {
    private ImplementedByProcessor() {
    }

    /**
     * Gets the wrapper class (descended from ElementImpl) for the annotation @ImplementedBy.
     *
     * @param iFace iface to process for annotations
     * @param <T>   type of the wrapped class.
     * @return The class name of the class in question
     */
    public static <T> Class<?> getWrapperClass(Class<T> iFace) {
        if (iFace.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iFace.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (Element.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " +
                iFace.getCanonicalName() + " if you want to extend ");
    }
}
