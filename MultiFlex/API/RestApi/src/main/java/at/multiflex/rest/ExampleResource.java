package at.multiflex.rest;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
    @RestClient
    PostService postService;
    @GET
    public Response hello() {
        List<Post> posts = new ArrayList<>(0);
        try {
            posts = postService.getAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Response.ok(posts).build();
    }
}