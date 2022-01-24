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
public class EmpLibInfoService {
	@Autowired
	EmpLibMapper emplibMapper;
	@Autowired
	EmployeeMapper empMapper;
	
	public void execute(Integer libNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empMapper.getEmpNum(empId);
		model.addAttribute("empNum", empNum);
		EmpLibDTO dto = emplibMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
	}

}
