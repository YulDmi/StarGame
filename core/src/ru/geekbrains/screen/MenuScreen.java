package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img, img2;
    private Vector2 pos;
    private Vector2 n;
    private float length;
    private int X, Y;

    @Override
    public void show() {
        super.show();
        img2 = new Texture("69.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        n = new Vector2();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (pos.len() < length) {
            pos.add(n);
        } else {
            pos.set(X, Y);
        }
        batch.begin();
        batch.draw(img2, 0, 0, 650, 500);
        batch.draw(img, pos.x, pos.y, 128, 128);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        img2.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pos.set(0, 0);
        X = screenX;
        Y = Gdx.graphics.getHeight() - screenY;
        n.set(X, Y);
        length = n.len();
        n.nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
