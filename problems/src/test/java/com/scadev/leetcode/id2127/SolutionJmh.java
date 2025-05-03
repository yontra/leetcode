package com.scadev.leetcode.id2127;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SolutionJmh {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionJmh.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    int[] arg;
    Solution s;

    @Setup
    public void up() {
        int[] val = new int[100000];
        for (int i = 0; i < val.length - 5; i++) {
            val[i] = i + 5;
        }
        val[99994] = 99999;
        val[99995] = 99999;
        val[99996] = 99999;
        val[99997] = 99999;
        val[99998] = 99999;
        val[99999] = 99998;

        this.s = new Solution();
        this.arg = val;
    }

    @Benchmark
    public double bench() {
        return this.s.maximumInvitations(this.arg);
    }
}
