package dao;

import java.util.List;

public interface Repository<TEntity> {

	public void add(TEntity entity);
	public void delete(TEntity entity);
	public TEntity get(int id);
	public List<TEntity> getAll();
	
}
