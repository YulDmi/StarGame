package ru.geekbrains.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class ExitButton extends Sprite {

    public ExitButton(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(-worldBounds.getHalfHeight());
        setRight(worldBounds.getHalfWidth());
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (this.isMe(touch)) {
            scale = 0.9f;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        scale = 1f;
        if (isMe(touch)) {
            Gdx.app.exit();
        }
        return false;
    }
}
