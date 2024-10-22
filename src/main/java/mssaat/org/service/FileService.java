package mssaat.org.service;

import java.io.File;
import java.io.IOException;

public interface FileService {
    public void salvar(Long id, String nomeImagem, byte[] imagem);
    public String salvarImagem(String nomeImagem, byte[] imagem) throws IOException;
    public void deleteImagem(Long id) throws IOException;
    public File download(String nomeImagem);
}