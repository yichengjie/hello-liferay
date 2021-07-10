package com.yicj.portlet.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SpringPortlet implements Controller{
	
	@Override
	public void handleActionRequest(ActionRequest request, ActionResponse response) throws Exception {
		
	}

	@Override
	public ModelAndView handleRenderRequest(RenderRequest request,RenderResponse response) throws Exception {
		Map<String,Object> model = new HashMap<String,Object>();
		log.info("运行到了这里哦");
		System.out.println("运行到了这里哦-------------");
		model.put("helloWorldMessage", "Hello World");
		//ModelAndView("view",model)   //这里面的view  对应了 /html/myliferayspringmvc/view.jsp
		return new ModelAndView("view",model);
	}
}
