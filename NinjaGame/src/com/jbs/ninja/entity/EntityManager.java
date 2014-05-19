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

	public void add(Entity e) {
		newEntities.add(e);
	}

	public void tick() {
		Iterator<Entity> e = entities.iterator();
		while (e.hasNext()) {
			Entity ent = e.next();
			if (ent instanceof Tickable) {
				((Tickable) ent).tick();
			}
			if (!ent.isAlive()) {
				ent.destroy();
				e.remove();
			}
		}
		for (Entity newEnt : newEntities) {
			newEnt.create();
			entities.add(newEnt);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		for (Entity e : entities) {
			if (e instanceof Renderable)
				((Renderable) e).render(batch);
		}
	}

	public void reset() {
		for (Entity e : entities) {
			e.kill();
		} 
	}
}
