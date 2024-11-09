package br.unitins.tp1.faixas.resource;

import java.util.List;

import br.unitins.tp1.faixas.dto.FaixaRequestDTO;
import br.unitins.tp1.faixas.model.Faixa;
import br.unitins.tp1.faixas.service.FaixaService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/faixas")
public class FaixaResource {

 @Inject
    public FaixaService faixaService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Adm", "User"})
    public Faixa findById(@PathParam("id") Long id) {
        return faixaService.findById(id);
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed("Adm")
    public List<Faixa> findByNome(@PathParam("nome") String nome) {
        return faixaService.findByNome(nome);
    }

    @GET
    public List<Faixa> findAll() {
        return faixaService.findAll();
    }

    @POST
    public Faixa create(FaixaRequestDTO faixa) {

        return faixaService.create(faixa);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, FaixaRequestDTO faixa) {
        faixaService.update(id, faixa);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        faixaService.delete(id);
    }
    
}
