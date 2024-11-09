package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.LoteRequestDTO;
import br.unitins.tp1.faixas.model.Lote;
import br.unitins.tp1.faixas.repository.LoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {

    @Inject
    public LoteRepository loteRepository;

    @Inject
    public FaixaService faixaService;

    @Override
    public Lote findById(Long id) {
        return loteRepository.findById(id);
    }

    @Override
    public Lote findByIdFaixa(Long idFaixa) {
        return loteRepository.findByIdFaixa(idFaixa);
    }

    @Override
    public Lote findByCodigo(String codigo) {
        return loteRepository.findByCodigo(codigo);
    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll().list();
    }

    @Override
    @Transactional
    public Lote create(LoteRequestDTO dto) {
        // buscando o estado a partir de um id do lote
        Lote lote = new Lote();
        lote.setFaixa(faixaService.findById(dto.idFaixa()));
        lote.setCodigo(dto.codigo());
        lote.setData(dto.data());
        lote.setEstoque(dto.estoque());

        //salvando o lote
        loteRepository.persist(lote);
        
        return lote;
    }

    @Override
    @Transactional
    public Lote update(Long id, LoteRequestDTO dto) {
        Lote lote = loteRepository.findById(id);

        lote.setFaixa(faixaService.findById(dto.idFaixa()));
        lote.setCodigo(dto.codigo());
        lote.setData(dto.data());
        lote.setEstoque(dto.estoque());

        return lote;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        loteRepository.deleteById(id);
    }
    
}
