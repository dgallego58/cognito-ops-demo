package co.com.cognito.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class GenericBuilder<T> {

    private boolean ifCond = true;
    private T instance;

    public GenericBuilder(Class<T> type) {
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            System.out.println("Cannot match the invocation " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <P> GenericBuilder<P> buildFor(Class<P> pClass) {
        return new GenericBuilder<>(pClass);
    }

    public GenericBuilder<T> disable(BooleanSupplier condition) {
        this.ifCond = condition.getAsBoolean();
        return this;
    }

    public GenericBuilder<T> enable() {
        this.ifCond = true;
        return this;
    }

    public GenericBuilder<T> with(Consumer<T> setter) {
        if (ifCond) {
            setter.accept(instance);
        }
        return this;
    }

    public T get() {
        return instance;
    }
}
