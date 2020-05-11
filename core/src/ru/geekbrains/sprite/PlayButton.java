package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class PlayButton extends Sprite {
    public PlayButton(Texture texture) {
                super(new TextureRegion(texture));
    }


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setBottom(-worldBounds.getHalfHeight());
        setLeft(-worldBounds.getHalfWidth());
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (isMe(touch)) {
            scale = 0.8f;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        scale = 1f;

        return isMe(touch);
    }

}
