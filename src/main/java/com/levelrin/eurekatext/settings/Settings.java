/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import com.amihaiemil.eoyaml.YamlMapping;
import com.levelrin.eurekatext.settings.homepage.DefaultHome;
import com.levelrin.eurekatext.settings.homepage.HomePage;
import com.levelrin.eurekatext.settings.homepage.HomeType;

/**
 * It represents the settings file.
 */
public final class Settings implements SettingsType {

    /**
     * It represents the settings.yaml.
     */
    private final YamlMapping yaml;

    /**
     * Constructor.
     * @param yaml See {@link Settings#yaml}.
     */
    public Settings(final YamlMapping yaml) {
        this.yaml = yaml;
    }

    @Override
    public HomeType homePage() {
        final YamlMapping homeYaml = this.yaml.yamlMapping("home-page");
        final HomeType homePage;
        if (homeYaml == null) {
            homePage = new DefaultHome();
        } else {
            homePage = new HomePage(homeYaml);
        }
        return homePage;
    }

}
