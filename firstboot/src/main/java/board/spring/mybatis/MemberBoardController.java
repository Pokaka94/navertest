package board.spring.mybatis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
@GetMapping("/boardlogin")
public String loginform() {
	return "board/loginform";
}
@PostMapping("/boardlogin")
public String loginprocess(String memberid, int pw, HttpSession session) {
	//1> c_member id, pw 확인
	MemberDTO dto = service.oneMember(memberid);
	if(dto != null) {
		if(dto.getPw() == pw) {
			session.setAttribute("sessionid", memberid);
		}
		else {
			//암호가 다르면 암호 다시 입력해야 한다
			//session.setAttribute("sessionid", "암호 다시 입력해야 한다");
		}
	}
	else {
		//id 회원가입부터 해야 한다
		//session.setAttribute("sessionid", "회원가입부터 해야 한다");
	}
	
	return "board/start";
}
@RequestMapping("/boardlogout")
public String logout(HttpSession session) {
	if(session.getAttribute("sessionid") != null) {//로그인 먼저 해야 로그아웃 가능한다
		System.out.println(session.getAttribute("sessionid"));
	session.removeAttribute("sessionid");
	}
	return "board/start";
}

}
