package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.geekbrains.StarGame;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;


public class NewGameButton extends ScaledButton {

   private StarGame starGame;
    public NewGameButton(TextureAtlas atlas, StarGame game) {

        super(atlas.findRegion("button_new_game"));
        this.starGame = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setBottom(-0.2f);
    }

    @Override
    public void action() {
        starGame.setScreen(new GameScreen());
    }

}
