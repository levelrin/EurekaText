/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.textlist;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * Text list on the home page.
 */
public final class TextList {

    /**
     * JavaFX component for rendering.
     * @return Text list UI.
     */
    public Node node() {
        final VBox box = new VBox(
            this.text(),
            this.text(),
            this.text(),
            this.text(),
            this.text(),
            this.text(),
            this.text()
        );
        final ScrollPane root = new ScrollPane(box);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.getStylesheets().add("text-list.css");
        return root;
    }

    /**
     * Create a sample text in the text list.
     * @return Sample text UI.
     */
    private Node text() {
        final String firstLine = "Ellipsis should be display if the text is too long.";
        final Label title = new Label("title");
        title.getStyleClass().add("title");
        final Label ellipsis = new Label(firstLine);
        ellipsis.getStyleClass().add("firstLine");
        final Label tag = new Label("tag");
        tag.getStyleClass().add("tag");
        final Label time = new Label("time");
        time.getStyleClass().add("date");
        final VBox boxUno = new VBox(
            title,
            ellipsis,
            new Group(tag),
            time,
            new Separator()
        );
        boxUno.getStyleClass().add("textVbox");
        return boxUno;
    }

}
