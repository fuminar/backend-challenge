package com.mercadoeletronico.challenge.item.api.dto;

import com.mercadoeletronico.challenge.item.domain.Item;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemResponse {

    private String descricao;

    private BigDecimal precoUnitario;

    private Long qtd;

    public static ItemResponse from(Item item) {
        return ItemResponse.builder()
                .descricao(item.getDescricao())
                .precoUnitario(item.getPrecoUnitario())
                .qtd(item.getQuantidade())
                .build();
    }

}
