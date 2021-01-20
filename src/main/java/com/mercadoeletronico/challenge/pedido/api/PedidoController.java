package com.mercadoeletronico.challenge.pedido.api;

import com.mercadoeletronico.challenge.pedido.api.dto.PedidoRequest;
import com.mercadoeletronico.challenge.pedido.api.dto.PedidoResponse;
import com.mercadoeletronico.challenge.pedido.domain.Pedido;
import com.mercadoeletronico.challenge.pedido.domain.PedidoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@RestController
@RequestMapping(path = "/api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @PostMapping
    @ApiOperation(value = "Insere um Pedido", response = PedidoResponse.class, responseContainer = "PedidoResponse")
    public ResponseEntity<PedidoResponse> cadastrar(@Valid @RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRepository.save(pedidoRequest.toModel());
        return ResponseEntity.ok(PedidoResponse.from(pedido));
    }

}
