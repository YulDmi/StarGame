package ru.geekbrains.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.StarGame;
import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.ExitButton;
import ru.geekbrains.sprite.Logo;
import ru.geekbrains.sprite.PlayButton;

public class MenuScreen extends BaseScreen {
    private StarGame starGame;
    private Texture bg;
    private Texture eb;
    private Texture pb;
    private Background background;
    private ExitButton exitButton;
    private PlayButton playButton;

    public MenuScreen(StarGame starGame) {
        this.starGame = starGame;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("69.jpg");
        eb = new Texture("exit.png");
        pb = new Texture("play.png");
        background = new Background(bg);
        exitButton = new ExitButton(eb);
        playButton = new PlayButton(pb);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        exitButton.resize(worldBounds);
        playButton.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        exitButton.draw(batch);
        playButton.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        eb.dispose();
        pb.dispose();
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
        if (playButton.touchUp(touch, pointer, button)){
            starGame.setScreen(new GameScreen());
        }
        return false;
    }
}
