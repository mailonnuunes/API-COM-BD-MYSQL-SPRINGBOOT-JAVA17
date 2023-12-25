package com.example.ApiClientes.controllers;

import com.example.ApiClientes.domains.Cliente;
import com.example.ApiClientes.dtos.DadosAtualizacaoCliente;
import com.example.ApiClientes.dtos.DadosCadastroCliente;
import com.example.ApiClientes.dtos.DadosListagemCliente;
import com.example.ApiClientes.interfaces.IClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository repository;

    @PostMapping
    @Transactional
    public void Cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public Page<DadosListagemCliente> MostrarTodosClientes(@PageableDefault(size = 2, sort = {"nome","idade"})Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }
    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarinformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void Deletar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
    }
}
