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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        final HBox newMemo = new HBox(new StackPane(plus), newMemoLabel);
        newMemo.getStyleClass().add("entity");
        final FontIcon searchIcon = new FontIcon(FontAwesome.SEARCH);
        final TextField searchField = new TextField();
        searchField.setPromptText("search");
        final HBox search = new HBox(new StackPane(searchIcon), searchField);
        search.getStyleClass().add("entity");
        final HBox root = new HBox(newMemo, search);
        root.getStylesheets().add("top-bar.css");
        root.setAlignment(Pos.CENTER_RIGHT);
        root.setId("top-bar-root");
        return root;
    }

}
