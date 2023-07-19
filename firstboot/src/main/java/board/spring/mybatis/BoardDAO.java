package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface BoardDAO {
	public int insertBoard(BoardDTO dto) ;
	
	public int getTotalBoard();

	public List<BoardDTO> boardList(int[] limit);
	
	public int updateViewcount(int seq) ;
	
	public BoardDTO getDetail(int seq) ;
	
	public int deleteBoard(int seq) ;
	
	public int updateBoard(BoardDTO dto) ;
	
	
	
	
	
}
