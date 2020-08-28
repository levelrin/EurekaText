/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

/**
 * It represents the 'texts' folder.
 * EurekaTexts finds all the text files from that folder.
 */
public final class Texts {

    /**
     * A function to check if the 'texts' folder exists.
     * Return true if the folder exists.
     * Return false otherwise.
     *
     * Unfortunately, JDK's static methods make our lives difficult to write unit tests.
     * For that reason, we decided to wrap it with a function.
     */
    private final Supplier<Boolean> folderExists;

    /**
     * A function to create the 'texts' folder.
     * Return the {@link Path} because JDK does so.
     * We should call this if the 'texts' folder did not exist already.
     *
     * The motivation to create this function is the same as {@link Texts#folderExists}.
     */
    private final Supplier<Path> createFolder;

    /**
     * Secondary constructor.
     */
    public Texts() {
        this(
            () -> Files.isDirectory(Paths.get("texts")),
            () -> {
                try {
                    return Files.createDirectory(Paths.get("texts"));
                } catch (final IOException ex) {
                    throw new IllegalStateException("Failed to create the 'texts' folder.", ex);
                }
            }
        );
    }

    /**
     * Primary constructor.
     * We will use this for testing.
     * @param folderExists See {@link Texts#folderExists}.
     * @param createFolder See {@link Texts#createFolder}.
     */
    public Texts(final Supplier<Boolean> folderExists, final Supplier<Path> createFolder) {
        this.folderExists = folderExists;
        this.createFolder = createFolder;
    }

    /**
     * This method is supposed to be called when the program starts.
     * It will check if the 'texts' exists.
     * If the folder does not exist, it will create one.
     */
    public void init() {
        if (!this.folderExists.get()) {
            this.createFolder.get();
        }
    }

}
