package springBootTest2.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsDTO")
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	Date goodsDate;
	String goodsContent;
	Integer goodsQty;
	String goodsCompany;
	Integer empNum;
}
