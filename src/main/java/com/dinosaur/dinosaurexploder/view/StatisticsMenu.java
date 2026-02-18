/*
 * SPDX-FileCopyrightText: 2026 jvondermarck
 * SPDX-License-Identifier: MIT
 */

package com.dinosaur.dinosaurexploder.view;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.scene.SubScene;
import com.dinosaur.dinosaurexploder.constants.GameConstants;
import com.dinosaur.dinosaurexploder.utils.LanguageManager;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class StatisticsMenu extends SubScene {
  public StatisticsMenu(int score, String time, int coins, int currentLevel, int heartsCollected) {
    LanguageManager lm = LanguageManager.getInstance();

    // Dim game background
    var bg = new Rectangle(getAppWidth(), getAppHeight(), Color.rgb(0, 0, 0, 0.85));

    String titleStr = lm.getTranslation("game_over").toUpperCase();
    double titleSize = titleStr.length() > 10 ? (550.0 / titleStr.length()) * 0.9 : 48;

    Text title = getUIFactoryService().newText(titleStr, Color.LIME, titleSize);

    Text scoreText =
        getUIFactoryService()
            .newText(
                String.format("%s: %d", lm.getTranslation("score"), score),
                Color.YELLOW,
                GameConstants.TEXT_SUB_DETAILS);

    Text timeText =
        getUIFactoryService()
            .newText(
                String.format("%s: %s", lm.getTranslation("time_survived"), time),
                Color.WHITE,
                GameConstants.TEXT_SUB_DETAILS);

    Text levelText =
        getUIFactoryService()
            .newText(
                String.format("%s: %d", lm.getTranslation("level_reached"), currentLevel),
                Color.WHITE,
                GameConstants.TEXT_SUB_DETAILS);

    Text heartsText =
        getUIFactoryService()
            .newText(
                String.format("%s: %d", lm.getTranslation("hearts_collected"), heartsCollected),
                Color.WHITE,
                GameConstants.TEXT_SUB_DETAILS);

    Text coinsText =
        getUIFactoryService()
            .newText(
                String.format("%s: %d", lm.getTranslation("coins_collected"), coins),
                Color.WHITE,
                GameConstants.TEXT_SUB_DETAILS);

    Text promptText = getUIFactoryService().newText(lm.getTranslation("new_game"), Color.WHITE, 16);
    promptText.setWrappingWidth(500);
    promptText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

    var btnYes = getUIFactoryService().newButton(lm.getTranslation("yes"));
    btnYes.setMinWidth(200);
    btnYes.setOnAction(e -> getGameController().startNewGame());

    var btnNo = getUIFactoryService().newButton(lm.getTranslation("no"));
    btnNo.setMinWidth(200);
    btnNo.setOnAction(e -> getGameController().gotoMainMenu());

    VBox box =
        new VBox(
            25,
            title,
            scoreText,
            timeText,
            levelText,
            heartsText,
            coinsText,
            promptText,
            btnYes,
            btnNo);
    box.setAlignment(Pos.CENTER);
    box.setPrefSize(getAppWidth(), getAppHeight());

    getContentRoot().getChildren().addAll(bg, box);
  }
}
