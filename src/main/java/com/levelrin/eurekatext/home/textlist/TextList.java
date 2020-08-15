/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home.textlist;

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
        final String firstLine = "Ellipsis should be display if the text is too long.";
        final Label titleUno = new Label("title1");
        final Label ellipsisUno = new Label(firstLine);
        final Label tagUno = new Label("tag1");
        final Label timeUno = new Label("time1");
        final VBox boxUno = new VBox(titleUno, ellipsisUno, tagUno, timeUno, new Separator());
        final Label titleDos = new Label("title2");
        final Label ellipsisDos = new Label(firstLine);
        final Label tagDos = new Label("tag2");
        final Label timeDos = new Label("time2");
        final VBox boxDos = new VBox(titleDos, ellipsisDos, tagDos, timeDos, new Separator());
        final VBox box = new VBox(boxUno, boxDos);
        final ScrollPane root = new ScrollPane(box);
        root.getStylesheets().add("text-list.css");
        return root;
    }

}
