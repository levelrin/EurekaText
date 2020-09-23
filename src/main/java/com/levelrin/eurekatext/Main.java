/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlMapping;
import com.levelrin.eurekatext.home.Home;
import com.levelrin.eurekatext.settings.EnsureSettingsFile;
import com.levelrin.eurekatext.settings.Settings;
import com.levelrin.eurekatext.settings.SettingsType;
import com.levelrin.eurekatext.texts.Texts;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Entry point of the program.
 */
@SuppressWarnings({"IllegalCatch", "PMD.AvoidCatchingGenericException"})
public final class Main extends Application {

    @Override
    public void start(final Stage stage) {
        try {
            final Path settingsPath = Paths.get("settings.yaml");
            final SettingsType settings = new EnsureSettingsFile(
                new Settings(
                    Yaml.createYamlInput(
                        settingsPath.toFile()
                    ).readYamlMapping()
                )
            );
            final Texts texts = new Texts();
            texts.init();
            new Home(settings).show(stage);
            stage.setOnCloseRequest(event -> {
                try {
                    final YamlMapping yaml = Yaml.createYamlMappingBuilder()
                        .add(
                            "home-page",
                            Yaml.createYamlMappingBuilder()
                                .add("width", Double.toString(stage.getWidth()))
                                .add("height", Double.toString(stage.getHeight()))
                                .build()
                        ).build();
                    Files.writeString(
                        settingsPath,
                        yaml.toString().replaceAll("\"", "").replaceAll("\r\n", "\n"),
                        StandardCharsets.UTF_8
                    );
                } catch (final IOException ex) {
                    throw new IllegalStateException(
                        "Failed to save the data before closing the software.",
                        ex
                    );
                }
            });
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
