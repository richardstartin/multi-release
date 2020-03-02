package io.github.richardstartin.onspinwait;

import org.openjdk.jmh.annotations.Benchmark;

public class OnSpinWaitOverhead {



    /*

    java -jar benchmarks.jar -tu us -i 5 -w 1 -wi 1 -r 1

    1.8.0_242-8u242-b08-0ubuntu3~18.04-b08

    Benchmark                           Mode  Cnt    Score    Error   Units
    OnSpinWaitOverhead.onSpinWaitMH    thrpt   25  458.375 ± 30.809  ops/us
    OnSpinWaitOverhead.onSpinWaitShim  thrpt   25  457.775 ± 32.669  ops/us

    11.0.6+10-post-Ubuntu-1ubuntu118.04.1

    Benchmark                           Mode  Cnt   Score   Error   Units
    OnSpinWaitOverhead.onSpinWaitMH    thrpt   25  20.478 ± 0.178  ops/us
    OnSpinWaitOverhead.onSpinWaitShim  thrpt   25  20.205 ± 0.605  ops/us

     */

    @Benchmark
    public boolean onSpinWaitShim() {
        return ThreadShim.onSpinWait();
    }


    @Benchmark
    public boolean onSpinWaitMH() {
        return MethodHandleImpl.onSpinWait();
    }
}
