package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Logo extends Sprite {
    private Vector2 v;
    private Vector2 copy;
    private final float LEN_V = 0.005f;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        v = new Vector2();
        copy = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);

    }

    @Override
    public void draw(SpriteBatch batch) {
        if (copy.cpy().sub(pos).len() > LEN_V) {
            pos.add(v);
        } else {
            pos.set(copy);
            v.setZero();
        }
        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        copy = touch.cpy();
        v.set(touch.sub(pos)).setLength(LEN_V);
        return false;
    }
}

