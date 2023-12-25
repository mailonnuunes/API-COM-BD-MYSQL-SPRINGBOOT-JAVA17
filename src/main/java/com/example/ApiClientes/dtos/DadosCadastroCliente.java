package com.example.ApiClientes.dtos;


import com.example.ApiClientes.enums.TipoDeCPF;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

public record DadosCadastroCliente(
       @NotBlank
       String nome,
       @NotBlank
       String sobrenome,
       @NotNull
       @Min(0)
       @Max(130)
       int idade,
       @NumberFormat
       String nomedamae,

        @NotNull
        TipoDeCPF tipodecpf
) {
}
