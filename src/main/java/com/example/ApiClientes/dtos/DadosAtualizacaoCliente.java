package com.example.ApiClientes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotNull
        String idade
) {

}
