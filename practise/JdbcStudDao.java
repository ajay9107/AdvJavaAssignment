package practice_jdbc;

import java.util.Collection;

public interface JdbcStudDao <T, K>{
	Collection<T> getAll();
	T getOne(K key);
	
	void add(T t);
	void update(T t);
	void delete(K key);
}
