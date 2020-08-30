package dev.shaw.gimmelife;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import dev.shaw.gimmelife.screens.PlayScreen;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class rougelike extends Game {
    TiledMap gamemap;
    OrthographicCamera camera = new OrthographicCamera();
    OrthogonalTiledMapRenderer CAM;
    public SpriteBatch batch;
    private TextureAtlas textureatlas;
    private Animation animation;
    private float elapsedTime = 0f;






    @Override
    public void create () {


       // Load map and set scale to 16x16
       gamemap = new TmxMapLoader().load("map1.tmx");
       CAM = new OrthogonalTiledMapRenderer(gamemap);

       // Create an orthographic camera, show us 16 units of the map

       camera.setToOrtho(false,650,1600);
       // 650,1600


       // Initialise new player
        batch = new SpriteBatch();
        textureatlas = new TextureAtlas(Gdx.files.internal("textures.atlas"));
        animation = new Animation(1/7f, textureatlas.findRegions("Sprites/Player/Sword/Defence0/Player_Idle_Sword_Defence0"));


       // Set camera position to character





    }

    //float xpos = 0;

    @Override
    public void render () {

        handleInput();
        elapsedTime += Gdx.graphics.getDeltaTime();
        CAM.setView(camera);
        CAM.render();
        camera.update();
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), 80, 400,40,40);
        batch.end();






       // Set the TiledMapRenderer view based on camera


       // Gdx.gl.glClearColor(1,1,1,1);
       // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //batch.begin();
       // batch.draw(atlas.findRegion("tile/grass_decorated"),0,0 );
        // Use findregions along with index of region to find numerated images
        //xpos += 1;
        //batch.end();
    }

    @Override
    public void dispose(){
        batch.dispose();
        textureatlas.dispose();


        //batch.dispose();
        //atlas.dispose();
    }

    private void handleInput(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)){
            camera.zoom += 0.02;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.X)){
            camera.zoom -= 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-1, 0, 0);
            //If the LEFT Key is pressed, translate the camera -3 units in the X-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(1, 0, 0);
            //If the RIGHT Key is pressed, translate the camera 3 units in the X-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -3, 0);
            //If the DOWN Key is pressed, translate the camera -3 units in the Y-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, 3, 0);
            //If the UP Key is pressed, translate the camera 3 units in the Y-Axis
        }
    }

}