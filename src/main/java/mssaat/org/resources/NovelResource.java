package mssaat.org.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mssaat.org.DTO.NovelDTO;
import mssaat.org.service.NovelServiceImpl;

@Path("/novel")
public class NovelResource {
    
    @Inject NovelServiceImpl novelService;

    @GET
     public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(novelService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(novelService.findById(id)).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name") String name) {
        return Response.ok(novelService.findByName(name)).build();
    }

    @GET
    @Path("/escritor/{escritorId}")
    public Response findByAutor(@PathParam("escritorId") long escritorId) {
        return Response.ok(novelService.findByEscritor(escritorId)).build();
    }

    @GET
    @Path("/genero/{genreId}")
    public Response findByGenre(@PathParam("genreId") int genreId) {
        return Response.ok(novelService.findByGenre(genreId)).build();
    }

    @POST
    public Response create(NovelDTO novel) {
        return Response.status(Status.CREATED).entity(novelService.create(novel)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, NovelDTO novel) {
        novelService.update(id, novel);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        novelService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
