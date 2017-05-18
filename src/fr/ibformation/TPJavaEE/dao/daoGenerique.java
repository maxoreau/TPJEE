package fr.ibformation.TPJavaEE.dao;

import java.util.List;

public interface daoGenerique<T> {
	
	public void create(T t);
	
	public List<T> readByName(String name);
	
	public void update(T t);
	
	public void delete(String s);
	
	public List<T> getAll();
	
	public int getId(T t);

}
