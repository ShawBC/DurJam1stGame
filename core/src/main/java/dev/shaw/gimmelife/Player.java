package dev.shaw.gimmelife;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.shaw.gimmelife.screens.PlayScreen;

public class Player extends Game {
    public SpriteBatch batch;
    private TextureAtlas textureatlas;
    private Animation animation;
    private float elapsedTime = 0f;


    @Override
    public void create() {
        batch = new SpriteBatch();
        textureatlas = new TextureAtlas(Gdx.files.internal("textures.atlas"));
        animation = new Animation(1/7f, textureatlas.findRegions("Sprites/Player/Sword/Defence0/Player_Idle_Sword_Defence0"));


        // "Sprites/Player/Sword/Defence0/Player_Idle_Sword_Defence0"
    }

    @Override
    public void dispose() {
        batch.dispose();
        textureatlas.dispose();
    }

    @Override
    public void render() {
        super.render();
        elapsedTime += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), 0, 0,80,80);
        batch.end();


    }
}