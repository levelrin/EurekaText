/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext;

import com.amihaiemil.eoyaml.Yaml;
import com.levelrin.eurekatext.home.Home;
import com.levelrin.eurekatext.settings.EnsureSettingsFile;
import com.levelrin.eurekatext.settings.Settings;
import com.levelrin.eurekatext.settings.SettingsType;
import com.levelrin.eurekatext.texts.Texts;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;

/**
 * Entry point of the program.
 */
@SuppressWarnings({"IllegalCatch", "PMD.AvoidCatchingGenericException"})
public final class Main extends Application {

    @Override
    public void start(final Stage stage) {
        try {
            final SettingsType settings = new EnsureSettingsFile(
                new Settings(
                    Yaml.createYamlInput(
                        new File("settings.yaml")
                    ).readYamlMapping()
                )
            );
            final Texts texts = new Texts();
            texts.init();
            new Home(settings).show(stage);
        } catch (final Exception ex) {
            // todo: display error message to the user.
            throw new IllegalStateException(
                "TODO: This exception should be displayed to the user.",
                ex
            );
        }
    }

    /**
     * Main method.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Application.launch();
    }

}
