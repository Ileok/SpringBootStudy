package springBootTest2.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(GoodsCommand goodsCommand) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsDate(goodsCommand.getGoodsDate());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		dto.setGoodsCompany(goodsCommand.getGoodsCompany());
		
		Integer i = goodsMapper.goodsUpdate(dto);
		System.out.println(i + "개 행이 수정되었습니다.");
	}
}
