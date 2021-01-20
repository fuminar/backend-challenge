package com.mercadoeletronico.challenge.pedido.api.dto;

import com.mercadoeletronico.challenge.commons.api.validators.Unique;
import com.mercadoeletronico.challenge.item.api.dto.ItemRequest;
import com.mercadoeletronico.challenge.pedido.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PedidoRequest {

    @NotEmpty(message = "{PedidoRequest.pedido.NotEmpty}")
    @Unique(entidade = Pedido.class, atributo = "codigoPedido", message = "{Pedido.codigoPedido.Unique}")
    private String pedido;

    private List<ItemRequest> itens;

    public Pedido toModel() {
        return Pedido.builder()
                .codigoPedido(pedido)
                .itens(itens.stream()
                        .map(ItemRequest::toModel)
                        .collect(Collectors.toList()))
                .build();
    }

}
