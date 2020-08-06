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
            this.categoryList(),
            this.bottomLeft()
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
        final FontIcon squareFirst = new FontIcon(FontAwesome.SQUARE);
        final Label categoryFirst = new Label("Category 1");
        final HBox firstBox = new HBox(squareFirst, categoryFirst);
        final FontIcon squareSecond = new FontIcon(FontAwesome.SQUARE);
        final Label categorySecond = new Label("Category 2");
        final HBox secondBox = new HBox(squareSecond, categorySecond);
        final FontIcon squareThird = new FontIcon(FontAwesome.SQUARE);
        final Label categoryThird = new Label("Category 3");
        final HBox thirdBox = new HBox(squareThird, categoryThird);
        final VBox wholeBox = new VBox(firstBox, secondBox, thirdBox);
        final ScrollPane root = new ScrollPane(wholeBox);
        root.getStylesheets().add("category-list.css");
        return root;
    }

    /**
     * Bottom left area of the home page.
     * @return Bottom left area.
     */
    private Node bottomLeft() {
        final FontIcon trash = new FontIcon(FontAwesome.TRASH);
        final Label deletedMemo = new Label("deleted memo");
        final HBox trashBox = new HBox(trash, new Group(deletedMemo));
        trashBox.setId("hBoxTrash");
        final FontIcon gear = new FontIcon(FontAwesome.GEAR);
        final Label setting = new Label("setting");
        final HBox settingBox = new HBox(gear, setting);
        final FontIcon plusCircle = new FontIcon(FontAwesome.PLUS_CIRCLE);
        final Label newCategory = new Label("new category");
        final HBox newBox = new HBox(plusCircle, newCategory);
        final VBox root = new VBox(trashBox, settingBox, newBox);
        root.getStylesheets().add("home-bottom-left.css");
        return root;
    }

}
