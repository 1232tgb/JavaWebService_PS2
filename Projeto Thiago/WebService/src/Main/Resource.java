package Main;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

    private DataBaseConnection dao;

    public Resource(DataBaseConnection dao) {
        this.dao = dao;
    }

    @GET
    public List<Produto> read() {
        return dao.Read();
    }

    @GET
    @Path("{id}")
    public Produto readOne(@PathParam("id") LongParam id) {
        long idGet = id.get();
        return dao.readSingle(idGet);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") LongParam id) {
        long idGet = id.get();
        return dao.Delete(idGet);
    }
    
    @POST
    public Produto create(Produto p){
       return dao.Create(p);
    }
    
    
    //Fazer o update
    
}
