package springBootTest2.mapper;

import java.util.List;

import springBootTest2.domain.EmpLibDTO;

public interface EmpLibMapper {

	public Integer autoNum();

	public Integer emplibInsert(EmpLibDTO dto);

	public List<EmpLibDTO> selectAll();

	public EmpLibDTO selectOne(Integer libNum);

	public void emplibUpdate(EmpLibDTO dto);

}
