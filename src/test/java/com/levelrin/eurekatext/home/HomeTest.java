/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class HomeTest {

    @Start
    public void start(final Stage stage) {
        new Home().show(stage);
    }

    @Test
    public void shouldDisplayHomePage(final FxRobot robot) {
        FxAssert.verifyThat(
            "#home-root",
            NodeMatchers.isVisible()
        );
    }

}
