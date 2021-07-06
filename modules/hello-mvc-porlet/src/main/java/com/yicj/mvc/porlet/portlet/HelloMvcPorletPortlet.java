package com.yicj.mvc.porlet.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.yicj.mvc.porlet.constants.HelloMvcPorletPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author yicj1
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HelloMvcPorlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HelloMvcPorletPortletKeys.HELLOMVCPORLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HelloMvcPorletPortlet extends MVCPortlet {
	private Logger logger = LoggerFactory.getLogger(HelloMvcPorletPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		String username = ParamUtil.getString(resourceRequest, "username");
		String password = ParamUtil.getString(resourceRequest, "password") ;
		logger.info("resourceID : {}", resourceID);
		logger.info("username : {}", username);
		logger.info("password : {}", password);
		resourceResponse.setContentType("text/html");
		resourceResponse.getWriter().write("Resource served successfully!");
	}
}