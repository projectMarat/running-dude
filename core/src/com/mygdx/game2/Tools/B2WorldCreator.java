package com.mygdx.game2.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game2.MarioBros;
import com.mygdx.game2.Screens.PlayScreen;
import com.mygdx.game2.Sprites.Enemies.Enemy;
import com.mygdx.game2.Sprites.Enemies.Goomba;
import com.mygdx.game2.Sprites.Enemies.Turtle;
import com.mygdx.game2.Sprites.Mario;


public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<Turtle> turtles;
    Mario player;
    public World world;
    public BodyDef bdef;
    public PolygonShape shape;
    public Body body;
    public FixtureDef fdef;
    public B2WorldCreator(PlayScreen screen, Mario player){
        this.player = player;
        world = screen.getWorld();
        TiledMap map = screen.getMap();
        bdef = new BodyDef();
        shape = new PolygonShape();
        fdef = new FixtureDef();


        for(MapObject object : map.getLayers().get("Ground").getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2 / MarioBros.PPM, rect.getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

    }

    public Array<Goomba> getGoombas() {
        return goombas;
    }
    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<Enemy>();
        return enemies;
    }
}
