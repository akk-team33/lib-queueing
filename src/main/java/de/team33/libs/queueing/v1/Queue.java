package de.team33.libs.queueing.v1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Queue {

    private static final Path ROOT = newRoot();

    private final Path path;

    public Queue(final String name) throws IOException {
        this.path = ROOT.resolve(name);
        Files.createDirectories(path);
    }

    private static Path newRoot() {
        final Path home = Optional.ofNullable(System.getProperties().getProperty("user.home"))
                .map(Paths::get)
                .orElseThrow(() -> new IllegalStateException("system property <user.home> not found"));
        return home.resolve(".runtime").resolve(Queue.class.getCanonicalName()).toAbsolutePath().normalize();
    }

    public void put(final String message) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
