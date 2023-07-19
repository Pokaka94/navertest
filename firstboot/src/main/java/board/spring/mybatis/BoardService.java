package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardDTO dto);
	public int getTotalBoard();
	public List<BoardDTO> boardList(int[] limit);
	public BoardDTO updateViewcountAndGetDetail(int seq);
	public int deleteBoard(int seq);
	public int updateBoard(BoardDTO dto);
}
