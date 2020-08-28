/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.texts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Tests.
 */
final class TextsTest {

    @Test
    public void shouldCreateFolderIfTextsFolderDoesNotExist() {
        final boolean[] created = {false};
        final Supplier<Path> createFolder = () -> {
            created[0] = true;
            return Path.of("fake");
        };
        new Texts(
            () -> false,
            createFolder
        ).init();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(true));
    }

    @Test
    public void shouldNotCreateFolderIfTextsFolderExists() {
        final boolean[] created = {false};
        final Supplier<Path> createFolder = () -> {
            created[0] = true;
            return Path.of("fake");
        };
        new Texts(
            () -> true,
            createFolder
        ).init();
        MatcherAssert.assertThat(created[0], CoreMatchers.equalTo(false));
    }

}
