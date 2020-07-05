/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Entry point of the program.
 */
public final class Main extends Application {

    @Override
    public void start(final Stage stage) {
        final Label label = new Label("Hello World");
        label.setId("hello");
        final Scene scene = new Scene(
            new StackPane(label),
            640,
            480
        );
        stage.setScene(scene);
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
