/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings.homepage;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
@SuppressWarnings("MagicNumber")
final class DefaultHomeTest {

    @Test
    public void widthShouldBe1225() {
        MatcherAssert.assertThat(
            new DefaultHome().width(),
            CoreMatchers.equalTo(1225.0)
        );
    }

    @Test
    public void heightShouldBe800() {
        MatcherAssert.assertThat(
            new DefaultHome().height(),
            CoreMatchers.equalTo(800.0)
        );
    }

}
