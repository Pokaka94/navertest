package board.spring.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;

//추가 메소드 정의 가능
	public MemberDTO oneMember(String id){
		return dao.oneMember(id);
	}


}//class end
