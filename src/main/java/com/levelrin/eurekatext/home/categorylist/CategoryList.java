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
        final FontIcon squareFirst = new FontIcon(FontAwesome.SQUARE);
        final Label categoryFirst = new Label("Category 1");
        final HBox firstBox = new HBox(squareFirst, categoryFirst);
        final FontIcon squareSecond = new FontIcon(FontAwesome.SQUARE);
        final Label categorySecond = new Label("Category 2");
        final HBox secondBox = new HBox(squareSecond, categorySecond);
        final FontIcon squareThird = new FontIcon(FontAwesome.SQUARE);
        final Label categoryThird = new Label("Category 3");
        final HBox thirdBox = new HBox(squareThird, categoryThird);
        final VBox wholeBox = new VBox(categoriesLabel, firstBox, secondBox, thirdBox);
        final ScrollPane root = new ScrollPane(wholeBox);
        root.getStylesheets().add("category-list.css");
        return root;
    }

}
