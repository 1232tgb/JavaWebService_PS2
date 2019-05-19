package Main;

import io.dropwizard.jackson.*;
import io.dropwizard.jersey.params.LongParam;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/Produtos")
//@Produces(MediaType.APPLICATION_JSON)
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
