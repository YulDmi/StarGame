package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.StarGame;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;


public class NewGameButton extends ScaledButton {

    private static final float ANIMATE_INTERVAL = 1f;
    private float animateTimer;
    private boolean scaleUp = true;
    private GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {

        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setBottom(-0.1f);
    }

    @Override
    public void update(float delta) {

        animateTimer += delta;
        if (animateTimer >= ANIMATE_INTERVAL) {
            animateTimer = 0f;
            scaleUp = !scaleUp;
        }
        if (scaleUp) {
            setScale(getScale() - 0.002f);
        } else
            setScale(getScale() + 0.002f);

    }


    @Override
    public void action() {
        gameScreen.startNewGame();
    }

}
