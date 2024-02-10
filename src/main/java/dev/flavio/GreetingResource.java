package dev.flavio;

import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/hello")
public class GreetingResource {

    @Channel("quarkus-rabbitmq")
    Emitter<JsonObject> emitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        JsonObject object = new JsonObject();
        object.put("Hello", "World");
        emitter.send(object);
        return "Hello from RESTEasy Reactive - A Mensagem Hello World foi enviada com sucesso!";
    }
}
