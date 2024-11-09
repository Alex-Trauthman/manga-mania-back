package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.FaixaRequestDTO;
import br.unitins.tp1.faixas.model.Faixa;
import br.unitins.tp1.faixas.repository.FaixaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FaixaServiceImpl implements FaixaService {

    @Inject
    public FaixaRepository faixaRepository;

    @Override
    public Faixa findById(Long id) {
        return faixaRepository.findById(id);
    }

    @Override
    public List<Faixa> findByNome(String nome) {
        return faixaRepository.findByNome(nome);
    }

    @Override
    public List<Faixa> findAll() {
        return faixaRepository.findAll().list();
    }

    @Override
    @Transactional
    public Faixa create(FaixaRequestDTO dto) {
        Faixa faixa = new Faixa();
        faixa.setNome(dto.nome());
        faixa.setPreco(dto.preco());

        faixaRepository.persist(faixa);
        return faixa;
    }

    @Override
    @Transactional
    public Faixa update(Long id, FaixaRequestDTO dto) {
        Faixa faixa = faixaRepository.findById(id);

        faixa.setNome(dto.nome());
        faixa.setPreco(dto.preco());

        return faixa;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        faixaRepository.deleteById(id);
    }
    
}
