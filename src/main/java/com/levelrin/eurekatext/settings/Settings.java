/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

/**
 * It represents the settings file.
 */
public final class Settings {

    /**
     * A function to check if the 'settings.yaml' file exists.
     * Return true if the file exists.
     * Return false otherwise.
     *
     * Unfortunately, JDK's static methods make our lives difficult to write unit tests.
     * For that reason, we decided to wrap it with a function.
     */
    private final Supplier<Boolean> fileExists;

    /**
     * A function to create the 'settings.yaml' file.
     * Return the {@link Path} because JDK does so.
     * We should call this if the 'settings.yaml' file did not exist already.
     *
     * The motivation to create this function is the same as {@link Settings#fileExists}.
     */
    private final Supplier<Path> createFile;

    /**
     * Secondary constructor.
     */
    public Settings() {
        this(
            () -> Files.isRegularFile(Paths.get("settings.yaml")),
            () -> {
                try {
                    return Files.createFile(Paths.get("settings.yaml"));
                } catch (final IOException ex) {
                    throw new IllegalStateException(
                        "Failed to create the 'settings.yaml' file.",
                        ex
                    );
                }
            }
        );
    }

    /**
     * Primary constructor.
     * We will use this for testing.
     * @param fileExists See {@link Settings#fileExists}.
     * @param createFile See {@link Settings#createFile}.
     */
    public Settings(final Supplier<Boolean> fileExists, final Supplier<Path> createFile) {
        this.fileExists = fileExists;
        this.createFile = createFile;
    }

    /**
     * This method is supposed to be called when the program starts.
     * It will check if the 'settings.yaml' exists.
     * If the file does not exist, it will create one.
     */
    public void init() {
        if (!this.fileExists.get()) {
            this.createFile.get();
        }
    }

}
