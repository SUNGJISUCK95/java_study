package member;

import java.util.List;

public interface GenericInterface<T> {
	//--8
	public int insert(T entity);
	public List<T> listAll();
	public int update(T entity);
	public int delete(int memberId);
	public T search(int memberId);
	public List<T> search(String name);
}
