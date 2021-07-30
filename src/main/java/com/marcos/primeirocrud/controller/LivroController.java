package com.marcos.primeirocrud.controller;

import com.marcos.primeirocrud.models.Livro;
import com.marcos.primeirocrud.services.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/livros")
public class LivroController {
    private final LivroService livroService;

    //CREATE
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.OK)
    public Livro cadastraLivro(@RequestBody Livro livro){
        return livroService.cadastraLivro(livro);
    }

    //READ
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> ListaLivros(){
        return livroService.listaLivros();
    }

    //UPDATE
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro atualizaLivro(@RequestBody Livro livro){
        return livroService.atualizaLivro(livro);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaLivro(@PathVariable Long id){
        livroService.deletaLivro(id);
    }

}
