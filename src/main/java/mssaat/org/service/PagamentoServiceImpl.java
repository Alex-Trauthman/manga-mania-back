package mssaat.org.service;

import java.util.List;

import mssaat.org.DTO.PagamentoDTO;
import mssaat.org.DTO.PagamentoResponseDTO;
import mssaat.org.model.Pagamento;
import mssaat.org.model.PagamentoEstado;
import mssaat.org.model.PagamentoTipo;
import mssaat.org.repository.PagamentoRepository;
import mssaat.org.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {
    @Inject
    public PagamentoRepository pagamentoRepository;

    @Override
    public long count() {
        return pagamentoRepository.count();
    }

    @Override
    @Transactional
    public PagamentoResponseDTO create(@Valid PagamentoDTO pagamentoDTO) {
        Pagamento pagamentoBanco = new Pagamento();
        
        pagamentoBanco.setTipo(PagamentoTipo.valueOf(pagamentoDTO.tipo()));
        pagamentoBanco.setEstado(PagamentoEstado.valueOf(pagamentoDTO.estado()));
        pagamentoBanco.setPedido(pagamentoDTO.pedido());
        pagamentoRepository.persist(pagamentoBanco);
        return PagamentoResponseDTO.valueOf(pagamentoBanco);
    }

    @Override
    @Transactional
    public void update(Long id, PagamentoDTO pagamentoDTO) {
        Pagamento pagamentoBanco = pagamentoRepository.findById(id);
        if (pagamentoBanco == null) {
            throw new ValidationException("id", "Pagamento não existe.");
        }
        pagamentoBanco.setTipo(PagamentoTipo.valueOf(pagamentoDTO.tipo()));
        pagamentoBanco.setEstado(PagamentoEstado.valueOf(pagamentoDTO.estado()));
        pagamentoBanco.setPedido(pagamentoDTO.pedido());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        pagamentoRepository.deleteById(id);
    }

    @Override
    public List<PagamentoResponseDTO> findAll() {
        return pagamentoRepository.listAll().stream().map(e -> PagamentoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PagamentoResponseDTO findById(@PathParam("id") Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if(pagamento == null) return null;
        return PagamentoResponseDTO.valueOf(pagamento);
    }
}