package me.hsgamer.minigamemapcore.api.setup;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class StepMapSetup implements Iterator<CompletableFuture<Void>> {
    private final Queue<Supplier<CompletableFuture<Void>>> steps = new LinkedList<>();

    public StepMapSetup addStep(Supplier<CompletableFuture<Void>> step) {
        steps.add(step);
        return this;
    }

    public StepMapSetup addStep(Step step) {
        addStep(() -> {
            step.apply();
            return CompletableFuture.completedFuture(null);
        });
        return this;
    }

    @Override
    public boolean hasNext() {
        return !steps.isEmpty();
    }

    @Override
    public CompletableFuture<Void> next() {
        return Optional.ofNullable(steps.poll()).map(Supplier::get).orElseThrow(NoSuchElementException::new);
    }

    @FunctionalInterface
    public interface Step {
        void apply();
    }
}
