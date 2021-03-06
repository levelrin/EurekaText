/*
 * Copyright (c) 2020 Rin (https://www.levelrin.com)
 *
 * This file has been created under the terms of the MIT License.
 * See the details at https://github.com/levelrin/EurekaText/blob/master/LICENSE
 */

package com.levelrin.eurekatext.home;

import com.levelrin.eurekatext.home.bottomleft.BottomLeftHome;
import com.levelrin.eurekatext.home.categorylist.CategoryList;
import com.levelrin.eurekatext.home.content.Content;
import com.levelrin.eurekatext.home.textlist.TextList;
import com.levelrin.eurekatext.home.topbar.TopBar;
import com.levelrin.eurekatext.settings.SettingsType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Home page (initial screen).
 */
@SuppressWarnings("ClassDataAbstractionCoupling")
public final class Home {

    /**
     * Settings.
     */
    private final SettingsType settings;

    /**
     * Constructor.
     * @param settings See {@link Home#settings}.
     */
    public Home(final SettingsType settings) {
        this.settings = settings;
    }

    /**
     * Display the home page.
     * @param stage JavaFX stage.
     */
    public void show(final Stage stage) {
        final Node topBar = new TopBar().node();
        final VBox leftBox = new VBox(
            new CategoryList().node(),
            new BottomLeftHome().node()
        );
        leftBox.setId("left-box");
        final HBox hbox = new HBox(
            leftBox,
            new TextList().node(),
            new Content().node()
        );
        final VBox root = new VBox(
            topBar,
            hbox
        );
        root.setId("home-root");
        root.getStylesheets().add("home.css");
        StackPane.setAlignment(topBar, Pos.TOP_CENTER);
        final double width = this.settings.homePage().width();
        final double height = this.settings.homePage().height();
        final Scene scene = new Scene(root);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setScene(scene);
        stage.setTitle("EurekaText");
        stage.show();
    }

}
