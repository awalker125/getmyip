package uk.co.aw125.ms.get.my.ip.resource;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.aw125.ms.get.my.ip.models.RuntimeStats;
import uk.co.aw125.ms.get.my.ip.version.Version;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusResource.
 */
@Path("/diagnostics")
@Api(value = "/diagnostics", tags = {"Diagnostics"})
public class DiagnosticsResource {
  // static UserData userData = new UserData();

  /** The Constant logger. */
  private static final Logger logger = LogManager.getLogger(DiagnosticsResource.class);





  /**
   * Gets the JVM status.
   *
   * @return the JVM status.
   */
  @GET
  @Path("/test")
  @ApiOperation(value = "A keepalive page for loadbalancer(s)")
  @Produces({"text/plain"})
  public Response getStatusBasic() {
    return Response.ok("OK").build();
  }


  @GET
  @Path("/runtime")
  @ApiOperation(value = "Get runtime stats for the JVM", response = RuntimeStats.class)
  public Response getRuntimeStats() {
    RuntimeStats runtimeStats = new RuntimeStats();
    return Response.ok(runtimeStats).build();
  }



  @GET
  @Path("/version")
  @ApiOperation(value = "The version of this instance of the application")
  @Produces({"text/plain"})
  public Response getVersion() {
    return Response.ok(Version.VERSION).build();
  }


}
