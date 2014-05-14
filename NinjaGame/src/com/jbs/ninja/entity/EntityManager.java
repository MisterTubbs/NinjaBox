package com.jbs.ninja.entity;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbs.ninja.Renderable;
import com.jbs.ninja.Tickable;

public class EntityManager implements Renderable {

	public static enum EntityType {
	}
	
	private ArrayList<Entity> entities;
	private ArrayList<Entity> newEntities;

	public EntityManager() {
		entities = new ArrayList<Entity>();
		newEntities = new ArrayList<Entity>();
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	//store any changes because changing a list during iteration will cause errors
	public void add(Entity e) {
		newEntities.add(e);
	}
	
	//directly removing will cause errors if done during iteration
	//public void remove( Entity e )
	
	//redundant if entity exposes .kill() publicly
	//public void killEntity( Entity e )
	
	/* entity manager doesn't need to create entities, just store them */

	public void tick() {
		//advantage of using iterator vs loop is that removal can happen right after an entity dies
		//using a loop can do the same but causes a gap in the update for that frame. one object gets
		//looked over if the object isn't the last index of the list
		Iterator<Entity> e = entities.iterator();
		while( e.hasNext() ) {
			Entity ent = e.next();
			if(ent instanceof Tickable) {
				((Tickable)ent).tick();
			}
			if(!ent.isAlive()) {
				ent.destroy();
				e.remove();
			}
		}
		// add any waiting entities
		for(Entity newEnt : newEntities) {
			newEnt.create();
			entities.add( newEnt );
		}
	}
	
	@Override
	public void render( SpriteBatch batch ) {
		for(Entity e : entities) {
			if(e instanceof Renderable) 
				((Renderable)e).render( batch );
		}
	}
	
	public void reset() {
		//entities.clear(); //memory leak, concurrent modification errors etc
		for(Entity e : entities) {
			e.kill();
		} // all entities will be removed and notified of removal in the next frame
	}
}
