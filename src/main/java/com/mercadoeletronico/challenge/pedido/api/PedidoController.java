package com.mercadoeletronico.challenge.pedido.api;

import com.mercadoeletronico.challenge.pedido.api.dto.PedidoRequest;
import com.mercadoeletronico.challenge.pedido.api.dto.PedidoResponse;
import com.mercadoeletronico.challenge.pedido.domain.Pedido;
import com.mercadoeletronico.challenge.pedido.domain.PedidoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

@Api
@RestController
@RequestMapping(path = "/api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @GetMapping("/{codigoPedido}")
    @ApiOperation("Retorna um Pedido pelo codigoPedido")
    public ResponseEntity<PedidoResponse> findById(@PathVariable String codigoPedido) {
        Pedido pedido = pedidoRepository.findByCodigoPedido(codigoPedido)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(PedidoResponse.from(pedido));
    }

    @PostMapping
    @ApiOperation(value = "Insere um Pedido", response = PedidoResponse.class, responseContainer = "PedidoResponse")
    public ResponseEntity<PedidoResponse> cadastrar(@Valid @RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRepository.save(pedidoRequest.toModel());
        return ResponseEntity.ok(PedidoResponse.from(pedido));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edita um Pedido", response = PedidoResponse.class, responseContainer = "PedidoResponse")
    public ResponseEntity<PedidoResponse> update(@PathVariable UUID id, @Valid @RequestBody PedidoRequest pedidoRequest) {
        return pedidoRepository.findById(id)
                .map(sqlObj -> {
                    Pedido pedido = pedidoRequest.toModel();
                    pedido.setId(id);
                    pedido = pedidoRepository.save(pedido);
                    return ResponseEntity.ok(PedidoResponse.from(pedido));
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ApiOperation("Exclui um Pedido")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
