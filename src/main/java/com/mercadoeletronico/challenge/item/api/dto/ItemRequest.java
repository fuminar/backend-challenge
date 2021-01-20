package com.mercadoeletronico.challenge.item.api.dto;

import com.mercadoeletronico.challenge.item.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ItemRequest {

    @NotEmpty(message = "{ItemRequest.descricao.NotEmpty}")
    private String descricao;

    @NotNull(message = "{ItemRequest.descricao.NotNull}")
    private BigDecimal precoUnitario;

    @NotNull(message = "{ItemRequest.quantidade.NotNull}")
    private Long qtd;

    public Item toModel() {
        return Item.builder()
                .descricao(descricao)
                .precoUnitario(precoUnitario)
                .quantidade(qtd)
                .build();
    }

}
