package com.mercadoeletronico.challenge.pedido.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PedidoRepository extends CrudRepository<Pedido, UUID> {
}
