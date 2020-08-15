/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.topbar;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * Top bar on the home page.
 */
public final class TopBar {

    /**
     * JavaFX component for rendering.
     * @return Top bar UI.
     */
    public Node node() {
        final FontIcon plus = new FontIcon(FontAwesome.PLUS);
        final Label newMemoLabel = new Label("new memo");
        final HBox newMemo = new HBox(plus, newMemoLabel);
        final FontIcon searchIcon = new FontIcon(FontAwesome.SEARCH);
        final Label searchLabel = new Label("search");
        final HBox search = new HBox(searchIcon, searchLabel);
        final HBox root = new HBox(newMemo, search);
        root.getStylesheets().add("top-bar.css");
        root.setAlignment(Pos.CENTER_RIGHT);
        root.setId("top-bar-root");
        return root;
    }

}
