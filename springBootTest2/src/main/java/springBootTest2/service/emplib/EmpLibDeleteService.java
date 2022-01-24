package springBootTest2.service.emplib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;
import springBootTest2.mapper.EmployeeMapper;

@Component
@Service
public class EmpLibDeleteService {
	@Autowired
	EmpLibMapper emplibMapper;
	@Autowired
	EmployeeMapper empMapper;

	public String execute(Integer libNum, String libPw, Model model, HttpSession session) {
		String path = "thymeleaf/emplib/emplibList";
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empMapper.getEmpNum(empId);
		model.addAttribute("empNum", empNum);
		EmpLibDTO dto = emplibMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libPw) || 
				!dto.getEmpNum().equals(empNum)) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/emplibInfo";
		}
		path = "thymeleaf/emplib/emplibList";
		return path;
	}
}