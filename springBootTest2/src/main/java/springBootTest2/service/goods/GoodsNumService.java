package springBootTest2.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsNumService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	EmployeeMapper empMapper;
	
	public void execute(HttpSession session, Model model) {
		String goodsNum = goodsMapper.autoNum();
		model.addAttribute("goodsNum", goodsNum);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		System.out.println(empId);
		Integer empNum = empMapper.getEmpNum(empId);
		model.addAttribute("empNum", empNum);
	}
}
