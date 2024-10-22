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
import mssaat.org.DTO.EscritorNovelDTO;
import mssaat.org.service.EscritorNovelServiceImpl;

@Path("/escritorNovel")
public class EscritorNovelResource {
    
    @Inject EscritorNovelServiceImpl escritorNovelService;

    @GET
     public Response findAll(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(escritorNovelService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")long id) {
        return Response.ok(escritorNovelService.findById(id)).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name")String name) {
        return Response.ok(escritorNovelService.findByName(name)).build();
    }

    @GET
    @Path("/novel/{novelId}")
    public Response findByNovel(@PathParam("novelId")long novelId) {
        return Response.ok(escritorNovelService.findByNovel(novelId)).build();
    }

    @POST
    public Response create(EscritorNovelDTO escritorNovel) {
        return Response.status(Status.CREATED).entity(escritorNovelService.create(escritorNovel)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, EscritorNovelDTO escritorNovel) {
        escritorNovelService.update(id, escritorNovel);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        escritorNovelService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}