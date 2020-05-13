package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.StarGame;
import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.ExitButton;
import ru.geekbrains.sprite.PlayButton;
import ru.geekbrains.sprite.Star;

public class MenuScreen extends BaseScreen {
    private StarGame starGame;
    private Texture bg;
    private TextureAtlas atlas;
    private Background background;
    private ExitButton exitButton;
    private PlayButton playButton;
    private Star [] stars = new Star[256];

    public MenuScreen(StarGame starGame) {
        this.starGame = starGame;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        atlas = new TextureAtlas(Gdx.files.internal("textures/menuAtlas.tpack"));
        background = new Background(bg);
        exitButton = new ExitButton(atlas);
        playButton = new PlayButton(atlas, starGame);
        for (int i = 0; i < stars.length ; i++) {
            stars[i] = new Star(atlas);
        }

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        exitButton.resize(worldBounds);
        playButton.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }

    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        exitButton.draw(batch);
        playButton.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exitButton.touchDown(touch, pointer, button);
        playButton.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exitButton.touchUp(touch, pointer, button);
        if (playButton.touchUp(touch, pointer, button)) {
            starGame.setScreen(new GameScreen());
        }
        return false;
    }
}
