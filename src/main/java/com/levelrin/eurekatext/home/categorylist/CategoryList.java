/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.categorylist;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * Category list on the home page.
 */
public final class CategoryList {

    /**
     * JavaFX component for rendering.
     * @return Category list UI.
     */
    public Node node() {
        final Label categoriesLabel = new Label("8 categories");
        categoriesLabel.setId("categoriesLabel");
        final VBox categoriesBox = new VBox(
            this.category(),
            this.category(),
            this.category(),
            this.category(),
            this.category(),
            this.category(),
            this.category(),
            this.category()
        );
        categoriesBox.setId("categoriesBox");
        final ScrollPane scroll = new ScrollPane(categoriesBox);
        categoriesBox.prefWidthProperty().bind(scroll.widthProperty());
        final VBox root = new VBox(categoriesLabel, scroll);
        root.getStylesheets().add("category-list.css");
        return root;
    }

    /**
     * Create a sample category in the category list.
     * @return Sample category UI.
     */
    private Node category() {
        final FontIcon square = new FontIcon(FontAwesome.SQUARE);
        final Label category = new Label("Category");
        final HBox hbox = new HBox(square, category);
        hbox.getStyleClass().add("categoryBox");
        return hbox;
    }

}
