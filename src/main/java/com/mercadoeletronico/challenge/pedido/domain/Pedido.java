package com.mercadoeletronico.challenge.pedido.domain;

import com.mercadoeletronico.challenge.item.domain.Item;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Setter
    @GeneratedValue
    private UUID id;

    private String codigoPedido;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Item> itens;

}
