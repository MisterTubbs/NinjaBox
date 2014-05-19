package com.jbs.ninja.entity;

import java.util.ArrayList;

public class EntityManager {

	public static enum EntityType {
	}
	
	private ArrayList<Entity> entities;

	public EntityManager() {
		entities = new ArrayList<Entity>();
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void add(Entity e) {
		entities.add(e);
	}
	
	public void remove(Entity e) {
		entities.remove(e);
	}
	
	public void killEntity(Entity e) {
		e.kill();
	}
	
	public void spawnEntity(EntityType type, float x, float y) {
		//figure out a way to create an Entity based on the EntityType that is passed in. Don't want to hardcode a if/else block, though.
	}
	
	public void spawnEntity(Entity e) {
		add(e);
	}
	
	private boolean checkWithinBounds(int width, int height, Entity e) {
		float x = e.getPos().x;
		float y = e.getPos().y;
		return x >= 0 && x <= width && y >= 0 && y <= height;
	}

	public void tick(int width, int height) {
		for(int i = entities.size() - 1; i >= 0; i++) {
			Entity e = entities.get(i);
			e.tick();
			if(!checkWithinBounds(width, height, e)) killEntity(e);
			if(!e.isAlive()) remove(e);
		}
	}
	
	public void reset() {
		entities.clear();
	}
}
