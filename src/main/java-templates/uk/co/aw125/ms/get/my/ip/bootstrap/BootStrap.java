package uk.co.aw125.ms.get.my.ip.bootstrap;




import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class BootStrap.
 */
@SuppressWarnings("serial")
public class BootStrap extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("${project.version}-${jenkins.build}");
		//beanConfig.setSchemes(new String[] { "http" , "https"});
		//beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/getmyip/webapi");
		beanConfig.setResourcePackage("uk.co.aw125.ms.get.my.ip.resource");
		beanConfig.setScan(true);
	}

}
