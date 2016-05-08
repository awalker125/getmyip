package uk.co.aw125.ms.get.my.ip.resource;

import java.util.Iterator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusResource.
 */
@Path("/ip")
@Api(value = "/ip", tags = { "IP" })
public class IPResource {
	// static UserData userData = new UserData();

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(IPResource.class);

	/**
	 * Gets the JVM status.
	 *
	 * @return the JVM status.
	 */
	@GET
	@ApiOperation(value = "Get your public ip")
	@Produces({ "text/plain" })
	public Response getIp(@Context HttpServletRequest httpServletRequest,
			@Context HttpHeaders httpHeaders) {

		StringBuilder logEntry = new StringBuilder();

		logEntry.append(httpServletRequest.getRemoteAddr());

		MultivaluedMap<String, String> map = httpHeaders.getRequestHeaders();

		for (String key : map.keySet()) {
			logEntry.append("|");
			logEntry.append(key + "," + map.get(key));
		}

		logger.warn(logEntry.toString());

		String ipAddress = httpServletRequest.getRemoteAddr();

		return Response.ok(ipAddress).build();
	}

}
