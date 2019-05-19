package Main;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;


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
    
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam ("id") LongParam id, Produto p){
        p.SetId(id.get());
        Produto novoProduto = dao.Update(p);
        
        if(novoProduto != null){
            return Response.ok(novoProduto).build();
        }
        
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    
}
