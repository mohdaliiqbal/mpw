package pk.com.mypetworld.server.test;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

public class RunJettyWithServerClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server server = new Server(8080);
		HandlerCollection handlers = new HandlerCollection();

		WebAppContext restApiWebappContext = new WebAppContext(
		     "src/main/webapp", "/"
		);
		handlers.addHandler(restApiWebappContext);

		String mpwClientWebappBasePath ="../mpw-client";
		WebAppContext serviceWebappContext = new WebAppContext(
		     mpwClientWebappBasePath + "/app", "/client"
		);
		handlers.addHandler(serviceWebappContext);
	/*	XmlConfiguration conf = new XmlConfiguration(new File(
		   mpwClientWebappBasePath +  "test/webapp/WEB-INF/jetty-web.xml")
		.toURI().toURL().openStream());
		conf.configure(serviceWebappContext);
*/
		server.setHandler(handlers);
		server.start();
	}

}
