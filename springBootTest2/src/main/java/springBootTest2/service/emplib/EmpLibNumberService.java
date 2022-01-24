package springBootTest2.service.emplib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.mapper.EmpLibMapper;
import springBootTest2.mapper.EmployeeMapper;

@Component
@Service
public class EmpLibNumberService {
	@Autowired
	EmpLibMapper emplibMapper;
	@Autowired
	EmployeeMapper empMapper;
	
	public void execute(HttpSession session, Model model) {
		Integer libNum = emplibMapper.autoNum();
		model.addAttribute("libNum", libNum);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empMapper.getEmpNum(empId);
		model.addAttribute("empNum", empNum);
	}
}
