package springBootTest2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.GoodsCommand;
import springBootTest2.command.MemberCommand;
import springBootTest2.service.goods.GoodsDelService;
import springBootTest2.service.goods.GoodsInfoService;
import springBootTest2.service.goods.GoodsListService;
import springBootTest2.service.goods.GoodsNumService;
import springBootTest2.service.goods.GoodsUpdateService;
import springBootTest2.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsNumService goodsNumService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	GoodsDelService goodsDeleteService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand) {
		goodsUpdateService.execute(goodsCommand);
		return "redirect:goodsList";
	}
	@RequestMapping("goodsModify")
	public String goodsModify(@RequestParam(value="num") String goodsNum, Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	@RequestMapping("goodsDelete")
	public String goodsDelete(@RequestParam(value="num") String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:goodsList";
	}
	@RequestMapping("goodsInfo")
	public String goodsInfo(@RequestParam(value="num") String goodsNum,
			Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsInfo";
	}
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite(HttpSession session, Model model) {
		goodsNumService.execute(session, model);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand) {
		goodsWriteService.execute(goodsCommand);
		return "redirect:goodsList";
	}
	
}
