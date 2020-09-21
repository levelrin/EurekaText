/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlMapping;
import com.levelrin.eurekatext.settings.homepage.DefaultHome;
import com.levelrin.eurekatext.settings.homepage.HomePage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
final class SettingsTest {

    @Test
    public void shouldReturnHomePageObjectIfYamlIsComplete() {
        final YamlMapping yaml = Yaml.createYamlMappingBuilder().add(
            "home-page",
            Yaml.createYamlMappingBuilder().build()
        ).build();
        MatcherAssert.assertThat(
            new Settings(yaml).homePage(),
            CoreMatchers.instanceOf(HomePage.class)
        );
    }

    @Test
    public void shouldReturnDefaultHomeObjectIfYamlIsIncomplete() {
        MatcherAssert.assertThat(
            new Settings(Yaml.createYamlMappingBuilder().build()).homePage(),
            CoreMatchers.instanceOf(DefaultHome.class)
        );
    }

}
