package Main;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceProduto {

    private DataBaseConnection dao;
    
    public ResourceProduto(DataBaseConnection dao){
        this.dao = dao;
    }
    
    
    @GET
    public List<Produto> read(){
        return dao.Read();
    }
    
    @GET
    @Path("{id}")
    public Produto readOne(@PathParam("id") LongParam id){
        long idGet = id.get();
        return dao.readSingle(idGet);
    }
    
    
    
}
