package Main;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Server extends Application<Configuration> {

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/web", "/", "index.html"));
    }

    @Override
    public void run(Configuration t, Environment e) throws Exception {
        Conexao cn = new Conexao();
        DataBaseConnection dao = new DataBaseConnection(cn.GetConnection("jdbc:derby://localhost:1527/Produto"));
        e.jersey().register(new Resource(dao));
        e.jersey().setUrlPattern("/Catalogo/*");
    }

}
