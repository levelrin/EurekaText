/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings.homepage;

import com.amihaiemil.eoyaml.YamlMapping;

/**
 * Settings about the home page UI.
 */
public final class HomePage implements HomeType {

    /**
     * It's for parsing YAML.
     * It should be the content under the 'home-page' key.
     */
    private final YamlMapping yaml;

    /**
     * Constructor.
     * @param yaml A YAML parser.
     */
    public HomePage(final YamlMapping yaml) {
        this.yaml = yaml;
    }

    @Override
    public double width() {
        double value = this.yaml.doubleNumber("width");
        if (value == -1.0) {
            value = new DefaultHome().width();
        }
        return value;
    }

    @Override
    public double height() {
        double value = this.yaml.doubleNumber("height");
        if (value == -1.0) {
            value = new DefaultHome().height();
        }
        return value;
    }

}
