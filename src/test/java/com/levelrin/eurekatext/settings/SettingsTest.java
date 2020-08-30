/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Tests.
 */
final class SettingsTest {

    @Test
    public void shouldCreateFileIfSettingsFileDoesNotExist() {
        final boolean[] created = {false};
        final Supplier<Path> createFile = () -> {
            created[0] = true;
            return Path.of("settings.yaml");
        };
        new Settings(
            () -> false,
            createFile
        ).init();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(true));
    }

    @Test
    public void shouldNotCreateFileIfSettingsFileExists() {
        final boolean[] created = {false};
        final Supplier<Path> createFile = () -> {
            created[0] = true;
            return Path.of("settings.yaml");
        };
        new Settings(
            () -> true,
            createFile
        ).init();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(false));
    }

}
