package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.utils.Regions;

public class Enemy extends Sprite {
    private static final float SIZE = 0.1f;
    private static final float MARGIN = 0.05f;
    private Vector2 v;
    private Rect worldBounds;


    public Enemy() {
        regions = new TextureRegion[1];
        v = new Vector2(0, -0.3f);
    }


    public void set(TextureAtlas atlas) {
        this.regions[0] = Regions.split((atlas.findRegion("enemy2")), 1, 2, 2)[0];
    }


    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(SIZE);
        setTop(worldBounds.getTop() - MARGIN);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
