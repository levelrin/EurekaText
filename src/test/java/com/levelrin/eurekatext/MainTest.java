/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Start
    private void start(final Stage stage) {
        new Main().start(stage);
    }

    @Test
    public void shouldHaveText(final FxRobot robot) {
        FxAssert.verifyThat(
            "#hello",
            LabeledMatchers.hasText("Hello World")
        );
    }

}
