package db;

import java.util.List;

import com.scoremgm.model.MemberVo;

public interface GenericRepositoryInterface<T> { //여러 곳에서 사용하는 공통적인 부분만 T, entity로 선정한다
	int insert(T entity); //default void insert();
	int getCount();
	List<T> findAll();
	T find(String mid);
//	int update(T entity);
//	int remove(String no);
}
