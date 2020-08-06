/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * Home page (initial screen).
 */
public final class Home {

    /**
     * Return JavaFX UI component.
     * @return The initial screen.
     */
    public Scene scene() {
        final Node topBar = this.topBar();
        final Label categoriesLabel = new Label("8 categories");
        final VBox leftBox = new VBox(
            new Group(categoriesLabel),
            this.categoryList()
        );
        leftBox.setId("left-box");
        final VBox root = new VBox(
            topBar,
            leftBox
        );
        root.setId("home-root");
        root.getStylesheets().add("home.css");
        StackPane.setAlignment(topBar, Pos.TOP_CENTER);
        final double width = 825;
        final double height = 550;
        return new Scene(root, width, height);
    }

    /**
     * Create the top bar UI.
     * @return Top bar.
     */
    private Node topBar() {
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

    /**
     * Category list on the left.
     * @return Category list.
     */
    private Node categoryList() {
        final FontIcon square1 = new FontIcon(FontAwesome.SQUARE);
        final Label category1 = new Label("Category 1");
        final HBox hBox1 = new HBox(square1, category1);
        final FontIcon square2 = new FontIcon(FontAwesome.SQUARE);
        final Label category2 = new Label("Category 2");
        final HBox hBox2 = new HBox(square2, category2);
        final FontIcon square3 = new FontIcon(FontAwesome.SQUARE);
        final Label category3 = new Label("Category 3");
        final HBox hBox3 = new HBox(square3, category3);
        final VBox vBox = new VBox(hBox1, hBox2, hBox3);
        final ScrollPane root = new ScrollPane(vBox);
        root.getStylesheets().add("category-list.css");
        return root;
    }

}
