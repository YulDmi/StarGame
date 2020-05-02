package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {
    protected SpriteBatch batch;

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.9f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
      //  System.out.println("keyDown");
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
       // System.out.println("keyUp");
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
       // System.out.println("KeyTyped");
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       // System.out.println("X = " + screenX + "Y = " + screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
       // System.out.println("touchUp");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
     //   System.out.println("touchDragged");
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
       // System.out.println("mouse scroll");
        return false;
    }
}
