package com.mercadoeletronico.challenge.pedido.api.dto;

import com.mercadoeletronico.challenge.item.api.dto.ItemResponse;
import com.mercadoeletronico.challenge.pedido.domain.Pedido;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PedidoResponse {

    private String pedido;

    private List<ItemResponse> itens;

    public static PedidoResponse from(Pedido pedido) {
        return PedidoResponse.builder()
                .pedido(pedido.getCodigoPedido())
                .itens(pedido.getItens().stream()
                .map(ItemResponse::from)
                .collect(Collectors.toList()))
                .build();
    }

}
