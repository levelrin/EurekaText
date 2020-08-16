/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.content;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * Content of the text on the home page.
 * The user can edit the text from here.
 */
public final class Content {

    /**
     * JavaFX component for rendering.
     * @return The text content UI.
     */
    public Node node() {
        final Label datetimes = new Label(
            "last editied 07/07/2020 20:55 \tcreated 09/11/1995 19:24"
        );
        final FontIcon tagIcon = new FontIcon(FontAwesome.TAG);
        final Label tags = new Label("tags");
        final HBox hboxTags = new HBox(
            tagIcon,
            tags,
            this.tag("2020"),
            this.tag("highschool"),
            this.tag("yoiyoi"),
            new FontIcon(FontAwesome.PLUS_CIRCLE)
        );
        return new VBox(
            datetimes,
            hboxTags,
            new Separator(),
            new TextField("Test"),
            new TextArea("Sample Text")
        );
    }

    /**
     * Create a tag UI.
     * @param name Tag name.
     * @return Tag UI.
     */
    private Node tag(final String name) {
        final FontIcon remove = new FontIcon(FontAwesome.CLOSE);
        final Label label = new Label(name);
        return new HBox(label, remove);
    }

}
