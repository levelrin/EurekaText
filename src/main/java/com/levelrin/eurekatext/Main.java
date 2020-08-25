/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext;

import com.levelrin.eurekatext.home.Home;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry point of the program.
 */
public final class Main extends Application {

    @Override
    public void start(final Stage stage) {
        stage.setScene(new Home().scene());
        stage.setTitle("EurekaText");
        stage.show();
    }

    /**
     * Main method.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Application.launch();
    }

}
