package bys.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bys.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> selectList;
		selectList = selectList("sample.selectBoardList", map);

		return selectList;
	}
	
	
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("sample.insertBoard", map);
	}

}
