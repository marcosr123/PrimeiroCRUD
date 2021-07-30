package com.marcos.primeirocrud.services;

import com.marcos.primeirocrud.models.Livro;
import com.marcos.primeirocrud.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    //CREATE
    @Transactional
    public Livro cadastraLivro(Livro livro) {
        if(verificaLivro(livro)){
            return criar(livro);
        }
        throw new ServiceException("Dados Inválidos");
    }

    //READ
    public List<Livro> listaLivros() {
        return livroRepository.findAll();
    }

    //UPDATE
    @Transactional
    public Livro atualizaLivro(Livro livro) {
        if(verificaLivro(livro)){
            throw new ServiceException("Dados Inválidos");
        }
        return altera(livro);
    }

    //DELETE
    @Transactional
    public void deletaLivro(Long id){
        livroRepository.deleteById(id);
    }


    private Livro altera(Livro livro) {
        Livro updateLivro = livroRepository.findById(livro.getId()).get();
        updateLivro.setDescricao(livro.getDescricao());
        updateLivro.setNome(livro.getNome());
        updateLivro.setCodigo(livro.getCodigo());
        return livroRepository.save(updateLivro);
    }

    private boolean verificaLivro(Livro livro){
        Long id = livro.getId();
        String descricao = livro.getDescricao();
        if (livroRepository.findByDescricaoContainingIgnoreCase(descricao).isEmpty()) {
            if (livroRepository.findById(id).isPresent()) {
                return Boolean.FALSE;
            } else return Boolean.TRUE;
        }
        throw new ServiceException("Livro " + descricao + " já cadastrado!");
    }

    private Livro criar(Livro livro){
        return livroRepository.save(livro);
    }
}