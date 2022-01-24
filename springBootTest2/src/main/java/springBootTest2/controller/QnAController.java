package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.BoardCommand;
import springBootTest2.command.QnACommand;
import springBootTest2.service.qna.QnADelService;
import springBootTest2.service.qna.QnADetailService;
import springBootTest2.service.qna.QnAInfoService;
import springBootTest2.service.qna.QnAListService;
import springBootTest2.service.qna.QnAModifyService;
import springBootTest2.service.qna.QnAWriteService;

@Controller
@RequestMapping("qna")
public class QnAController {
	@Autowired
	QnAWriteService qnaWriteService;
	@Autowired
	QnAListService qnaListService;
	@Autowired
	QnADetailService qnaDetailService;
	@Autowired
	QnADelService qnaDelService;
	@Autowired
	QnAInfoService qnaInfoService;
	@Autowired
	QnAModifyService qnaModifyService;
	
	@RequestMapping(value = "qnaModify" ,  method = RequestMethod.POST)
	public String  qnaModify(QnACommand qnaCommand) {
		qnaModifyService.execute(qnaCommand);
		return "redirect:qnaDetail?num="+qnaCommand.getQnaNum();
	}
	@RequestMapping("qnaUpdate")
	public String qnaUpdate(HttpServletRequest request) {
		qnaInfoService.execute(request);
		return "thymeleaf/qna/qnaDetail";
	}
	
	@RequestMapping(value = "qnaDel", method = RequestMethod.GET)
	public String qnaDel(@RequestParam(value="num") Integer qnaNum) {
		qnaDelService.execute(qnaNum);
		return "redirect:qnaList";
	}
	
	@RequestMapping(value = "qnaDetail" ,method = RequestMethod.GET)
	public String boardDetail(@RequestParam(value = "num") Integer qnaNum,
			Model model) {
		qnaDetailService.execute(model, qnaNum);
		return "thymeleaf/qna/qnaInfo";
	}
	
	@RequestMapping(value="qnaRegist" , method = RequestMethod.POST) 
	public String boardRegist(QnACommand qnaCommand,
			HttpServletRequest request) {
		 qnaWriteService.execute(qnaCommand, request); 
		 return "redirect:qnaList"; 
	}
	
	@RequestMapping("qnaWrite")
	public String qnaForm() {
		return "thymeleaf/qna/qnaForm";
	}
	@RequestMapping("qnaList")
	public String qnaHome(Model model) {
		qnaListService.execute(model);
		return "thymeleaf/qna/qnaList";
	}
	
}