package com.ji.springP001.Board;

import java.util.List;
public interface boardMapper {

	public abstract int getBoardCount();
	public abstract List<Board> getAllBoard(int param1,int param2);
	public abstract int getMyBoardCount(String param1);
	public abstract List<Board> getMyBoard(String param1,String param2,String param3);
	public abstract void insertBoard(Board b);
	
}
