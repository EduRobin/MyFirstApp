package cz.myfirstapp;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@Path("users") //localhost:8080/MyFirstApp/api/path
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private static List<String> names = new ArrayList<String>();

    @GET //localhost:8080/MyFirstApp/api/users
    public Response getALL() {
        return Response.ok(names).build();
    }

    @POST // Add user to an array
    public Response createUser(String user) {
        if(userExist(user)) {
            return Response.ok().build();
        } else {
            return Response.status(406).build();
        }
    }

    public boolean userExist(String user) {
        for(int i=0; i < names.size(); i++) {
            if(names.get(i).equals(user))
                return true;
        }
        return false;
    }

    @DELETE
    public Response deleteUser(String user) {
        if(userExist(user)) {
            names.remove(user);
            return Response.ok("Uspěšně odstraněn").build();
        } else {
            return Response.status(406).build();
        }
    }

    @PUT
    public Response editUser(String name, String tempName) {
        for(int i=0; 1 < names.size(); i++) {
            if(names.get(i).equals(name)) {
                names.set(i, tempName);
                return Response.ok("User byl přejmenován").build();
            }
            else return Response.status(406).build();
        }
        return Response.status(406).build();
    }
}
