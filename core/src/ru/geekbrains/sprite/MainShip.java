package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MainShip extends Sprite {
    private Vector2 v;
    private Vector2 copy;
    private static final float LEN_V = 0.005f;

    public MainShip(TextureAtlas atlas) {
        this(atlas.findRegion("main_ship"));
        v = new Vector2();
        copy = new Vector2();
    }

    public MainShip(TextureRegion textureRegion) {
        super(new TextureRegion(textureRegion, 0, 0, textureRegion.getRegionWidth() / 2, textureRegion.getRegionHeight()));

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom());

    }

    @Override
    public void update(float delta) {
        if (copy.cpy().sub(pos).len() > LEN_V) {
            pos.add(v);
        } else {
            pos.set(copy);
            v.setZero();
        }
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        copy = touch.cpy();
        v.set(touch.sub(pos)).setLength(LEN_V);
        return false;
    }

}

