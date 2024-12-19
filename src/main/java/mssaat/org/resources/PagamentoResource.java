package mssaat.org.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mssaat.org.DTO.PagamentoDTO;
import mssaat.org.DTO.PagamentoResponseDTO;
import mssaat.org.service.PagamentoService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pagamentos")
public class PagamentoResource {
    @Inject
    public PagamentoService pagamentoService;

    @GET
    @RolesAllowed("Usuario")
    public Response findAll() {
        return Response.ok(pagamentoService.findAll()).build();
    }

    @GET
    @Path("/count")
    @RolesAllowed("Usuario")
    public long count() {
        return pagamentoService.count();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("Usuario")
    public Response findById(@PathParam("id") Long id) {
        PagamentoResponseDTO pagamento = pagamentoService.findById(id);
        if (pagamento == null)
            return Response.status(Status.NOT_FOUND).build();
        return Response.ok(pagamento).build();
    }

    @POST
    @RolesAllowed("Usuario")
    @Transactional
    public Response create(PagamentoDTO pagamentoDTO) {
        return Response.status(Status.CREATED).entity(pagamentoService.create(pagamentoDTO)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Usuario")
    @Transactional
    public Response update(@PathParam("id") Long id, PagamentoDTO pagamentoDto) {
        PagamentoResponseDTO pagamentoBanco = pagamentoService.findById(id);
        if (pagamentoBanco == null)
            return Response.status(Status.NOT_FOUND).build();
        pagamentoService.update(id, pagamentoDto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Usuario")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        pagamentoService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}