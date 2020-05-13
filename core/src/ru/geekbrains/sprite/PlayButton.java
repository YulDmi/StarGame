package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.StarGame;
import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class PlayButton extends ScaledButton {

    private static final float MARGIN = 0.05f;
    private StarGame starGame;

    public PlayButton(TextureAtlas atlas, StarGame game) {

        super(atlas.findRegion("btPlay"));
        this.starGame = game;
    }


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setBottom(worldBounds.getBottom() + MARGIN);
        setLeft(worldBounds.getLeft() + MARGIN);
    }


    @Override
    public void action() {
starGame.setScreen(new GameScreen());
    }

}
