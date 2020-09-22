/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings.homepage;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlMapping;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
@SuppressWarnings("MagicNumber")
final class HomePageTest {

    @Test
    public void widthShouldComeFromYaml() {
        final YamlMapping yaml = Yaml.createYamlMappingBuilder().add("width", "1225.0").build();
        MatcherAssert.assertThat(
            new HomePage(yaml).width(),
            CoreMatchers.equalTo(1225.0)
        );
    }

    @Test
    public void heightShouldComeFromYaml() {
        final YamlMapping yaml = Yaml.createYamlMappingBuilder().add("height", "800.0").build();
        MatcherAssert.assertThat(
            new HomePage(yaml).height(),
            CoreMatchers.equalTo(800.0)
        );
    }

    @Test
    public void defaultWidthShouldBeReturnedIfAbsentInYaml() {
        final YamlMapping yaml = Yaml.createYamlMappingBuilder().build();
        MatcherAssert.assertThat(
            new HomePage(yaml).width(),
            CoreMatchers.equalTo(1225.0)
        );
    }

    @Test
    public void defaultHeightShouldBeReturnedIfAbsentInYaml() {
        final YamlMapping yaml = Yaml.createYamlMappingBuilder().build();
        MatcherAssert.assertThat(
            new HomePage(yaml).height(),
            CoreMatchers.equalTo(800.0)
        );
    }

}
