package io.github.richardstartin.onspinwait;

public class ThreadShim {

    public static boolean onSpinWait() {
        Thread.onSpinWait();
        return true;
    }
}
