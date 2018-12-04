package bys.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bys.common.common.CommandMap;
import bys.sample.service.SampleService;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="sampleService")
    private SampleService sampleService;
   
    /************************************************************************************/
    /**   @RequestMapping�� ��û URL�� �ǹ��Ѵ�. 										         /
    /**   /sample/openSampleBoardList.do ��� �ּҸ� ȣ���ϰ� �Ǹ�,							     /
    /**   �� �ּҴ� @RequestMapping ������̼ǰ� ���εǾ�, �ش� �޼��尡 ����ȴ�.                          /
    /************************************************************************************/
    /*Bootsrap Sample*/
    @RequestMapping(value="/sample/openBootstrap.do")
    public ModelAndView openBootstrap(Map<String,Object> commandMap) throws Exception{
    	List<Map<String,Object>> list = null;//sampleService.selectBoardList(commandMap);
    	ModelAndView mv = new ModelAndView("/sample/bootstrap");
        mv.addObject("list", list);
        return mv;
    }
    
    @RequestMapping(value="/sample/openSampleBoardList.do")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
    	List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
    	ModelAndView mv = new ModelAndView("/sample/boardList");
        mv.addObject("list", list);
        return mv;
    }
    
    
    @RequestMapping(value="/sample/openBoardWrite.do")
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardWrite");
        return mv;
    }
    
    
    @RequestMapping(value="/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		if(commandMap.isEmpty() == false){
			Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String,Object> entry = null;
			while(iterator.hasNext()){
				entry = iterator.next();
				log.debug("key : "+entry.getKey()+",\tvalue : "+entry.getValue());
			}
		}
		return mv;
	}
    
    
    @RequestMapping(value="/sample/insertBoard.do")
    public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
        sampleService.insertBoard(commandMap.getMap());
        return mv;
    }

    
    
}


