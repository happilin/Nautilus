package com.nautilus.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.Board;

@Mapper
public interface BoardMapper {

	List<Board> getList();

	List<Board> getListBynum(int num);
	
	Board getInfoByDeptno(int num);
	
	int add(Board board);
	
	boolean update(Board board);
	
	//int edit(int num);
	List<Board> search(String key, String category);
	
	Boolean delete(int num);

	List<Board> search(Map<String, String> map);
}
