/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import com.levelrin.eurekatext.settings.homepage.HomeType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

/**
 * A decorator for {@link SettingsType}.
 * It makes sure the 'settings.yaml' exists.
 */
public final class EnsureSettingsFile implements SettingsType {

    /**
     * We use this object after ensuring the settings file.
     */
    private final SettingsType origin;

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
     * The motivation to create this function is the same as {@link EnsureSettingsFile#fileExists}.
     */
    private final Supplier<Path> createFile;

    /**
     * A flag that tells us if it checked the existence of the settings file or not.
     */
    private boolean checked;

    /**
     * Secondary constructor.
     * @param origin See {@link EnsureSettingsFile#origin}.
     */
    public EnsureSettingsFile(final SettingsType origin) {
        this(
            origin,
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
     * @param origin See {@link EnsureSettingsFile#origin}.
     * @param fileExists See {@link EnsureSettingsFile#fileExists}.
     * @param createFile See {@link EnsureSettingsFile#createFile}.
     */
    public EnsureSettingsFile(final SettingsType origin, final Supplier<Boolean> fileExists, final Supplier<Path> createFile) {
        this.origin = origin;
        this.fileExists = fileExists;
        this.createFile = createFile;
    }

    @Override
    public HomeType homePage() {
        if (!this.checked) {
            if (!this.fileExists.get()) {
                this.createFile.get();
            }
            this.checked = true;
        }
        return this.origin.homePage();
    }

}
