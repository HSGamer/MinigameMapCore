package me.hsgamer.minigamemapcore.api.setup;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class StepMapSetup implements Iterator<CompletableFuture<Void>> {
    private final Queue<Supplier<CompletableFuture<Void>>> steps = new LinkedList<>();

    public <T extends Supplier<CompletableFuture<Void>>> StepMapSetup addStep(T step) {
        steps.add(step);
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
    public interface SimpleStep extends Supplier<CompletableFuture<Void>> {
        void apply();

        default CompletableFuture<Void> get() {
            apply();
            return CompletableFuture.completedFuture(null);
        }
    }
}
