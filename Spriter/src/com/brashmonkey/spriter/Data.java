package com.brashmonkey.spriter;

import java.util.ArrayList;
import java.util.List;

public class Data {

	public final List<Folder> folders;
    public final List<Entity> entities;
    public final String scmlVersion, generator, generatorVersion;
    
    public Data(String scmlVersion, String generator, String generatorVersion){
    	this(scmlVersion, generator, generatorVersion, new ArrayList<Folder>(), new ArrayList<Entity>());
    }
    
    public Data(String scmlVersion, String generator, String generatorVersion, List<Folder> folders, List<Entity> entities){
    	this.scmlVersion = scmlVersion;
    	this.generator = generator;
    	this.generatorVersion = generatorVersion;
    	this.folders = folders;
    	this.entities = entities;
    }
    
    public void addFolder(Folder folder){
    	this.folders.add(folder);
    }
    
    public void addEntity(Entity entity){
    	this.entities.add(entity);
    }
    
    public Folder getFolder(int i){
    	return this.folders.get(i);
    }
    
    public Entity getEntity(int i){
    	return this.entities.get(i);
    }
    
    public Entity getEntity(String name){
    	int index = getEntityIndex(name);
    	if(index >= 0) return getEntity(index);
    	else return null;
    }
    
    public int getEntityIndex(String name){
    	for(Entity entity: this.entities)
    		if(entity.name.equals(name)) return entity.id;
    	return -1;
    }
    
    public File getFile(Folder folder, int file){
    	return folder.getFile(file);
    }
    
    public File getFile(int folder, int file){
    	return getFile(this.getFolder(folder), file);
    }
    
    public File getFile(FileReference ref){
    	return this.getFile(ref.folder, ref.file);
    }
    
    public String toString(){
    	String toReturn = getClass().getSimpleName()+"|[Version: "+scmlVersion+", Generator: "+generator+" ("+generatorVersion+")]";
    	for(Folder folder: folders)
    		toReturn += "\n"+folder;
    	for(Entity entity: entities)
    		toReturn += "\n"+entity;
    	toReturn+="]";
    	return toReturn;
    }

}
