package io.github.richardstartin.onspinwait;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

import static java.lang.invoke.MethodType.methodType;

public class MethodHandleImpl {

    private static final MethodHandle ON_SPIN_WAIT_HANDLE = resolve();

    private static MethodHandle resolve() {
        try {
            return MethodHandles.lookup().findStatic(
                    Thread.class, "onSpinWait", methodType(void.class));
        } catch (Exception ignore) {
        }

        return null;
    }

    static boolean onSpinWait() {
        if (ON_SPIN_WAIT_HANDLE != null) {
            try {
                ON_SPIN_WAIT_HANDLE.invokeExact();
                return true;
            } catch (Throwable ignore) {
            }
        }
        return false;
    }
}
