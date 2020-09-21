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
final class EnsureSettingsFileTest {

    @Test
    public void shouldCreateFileIfSettingsFileDoesNotExist() {
        final boolean[] created = {false};
        final Supplier<Path> createFile = () -> {
            created[0] = true;
            return Path.of("settings.yaml");
        };
        new EnsureSettingsFile(
            new FakeSettings(),
            () -> false,
            createFile
        ).homePage();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(true));
    }

    @Test
    public void shouldNotCreateFileIfSettingsFileExists() {
        final boolean[] created = {false};
        final Supplier<Path> createFile = () -> {
            created[0] = true;
            return Path.of("settings.yaml");
        };
        new EnsureSettingsFile(
            new FakeSettings(),
            () -> true,
            createFile
        ).homePage();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(false));
    }

    @Test
    public void shouldCreateFileOnlyOnce() {
        final int[] createdAmount = {0};
        final Supplier<Path> createFile = () -> {
            createdAmount[0] = createdAmount[0] + 1;
            return Path.of("settings.yaml");
        };
        final EnsureSettingsFile settings = new EnsureSettingsFile(
            new FakeSettings(),
            () -> false,
            createFile
        );
        settings.homePage();
        settings.homePage();
        MatcherAssert.assertThat(createdAmount[0], CoreMatchers.equalTo(1));
    }

}
