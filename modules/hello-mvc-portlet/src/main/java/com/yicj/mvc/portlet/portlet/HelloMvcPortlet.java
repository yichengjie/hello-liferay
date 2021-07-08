package com.yicj.mvc.portlet.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.util.PortalImpl;
import com.liferay.portal.util.PropsUtil;
import com.yicj.mvc.portlet.constants.HelloMvcPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yicj1
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HelloMvcPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HelloMvcPortletKeys.HELLOMVCPORLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HelloMvcPortlet extends MVCPortlet {
	private Logger logger = LoggerFactory.getLogger(HelloMvcPortlet.class);

	
	/**
	 * 登录业务处理
	 * 注意@ProcessAction中的name要与portlet:actionURL中的name对应
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	@ProcessAction(name = "loginAction")
	public void loginAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String username = ParamUtil.getString(actionRequest, "username") ;
		String password = ParamUtil.getString(actionRequest, "password") ;
		logger.info("username : {}", username);
		logger.info("password : {}", password);
		
		//PortalUtil.get*
		//PropertiesParamUtil.get
		String prop1 = PropsUtil.get("prop1");
		logger.info("prop1 : {}", prop1);
	}


	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		String username = ParamUtil.getString(resourceRequest, "username");
		String password = ParamUtil.getString(resourceRequest, "password") ;
		logger.info("resourceID : {}", resourceID);
		logger.info("username : {}", username);
		logger.info("password : {}", password);
		resourceResponse.setContentType("text/html");
		PrintWriter out = resourceResponse.getWriter();
		out.write("Resource served successfully!");
		out.flush();
		out.close();
	}
}