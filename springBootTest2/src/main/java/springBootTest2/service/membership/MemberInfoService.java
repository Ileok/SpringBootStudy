package springBootTest2.service.membership;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MembershipMapper;

@Component
@Service
public class MemberInfoService {
	@Autowired
	MembershipMapper membershipMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		MemberDTO dto = membershipMapper.selectOne(memId);
		model.addAttribute("dto", dto);
	}
}
