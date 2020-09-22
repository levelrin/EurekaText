/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings;

import com.levelrin.eurekatext.settings.homepage.DefaultHome;
import com.levelrin.eurekatext.settings.homepage.HomeType;

/**
 * For testing.
 */
public final class FakeSettings implements SettingsType {

    @Override
    public HomeType homePage() {
        return new DefaultHome();
    }

}
