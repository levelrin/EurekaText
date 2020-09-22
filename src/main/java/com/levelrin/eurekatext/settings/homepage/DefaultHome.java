/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.settings.homepage;

/**
 * Home page settings with default values.
 * We use this when the content of settings file is incomplete.
 */
@SuppressWarnings("MagicNumber")
public final class DefaultHome implements HomeType {

    @Override
    public double width() {
        return 1225;
    }

    @Override
    public double height() {
        return 800;
    }

}
