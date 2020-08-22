/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.bottomleft;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * The bottom-left corner area of the home page.
 */
public final class BottomLeftHome {

    /**
     * JavaFX component for rendering.
     * @return The bottom-left corner area of the home page UI.
     */
    public Node node() {
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
        root.setId("home-bottom-root");
        root.getStylesheets().add("home-bottom-left.css");
        return root;
    }

}
