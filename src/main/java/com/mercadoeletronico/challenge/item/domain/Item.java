package com.mercadoeletronico.challenge.item.domain;

import com.mercadoeletronico.challenge.pedido.domain.Pedido;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Setter
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Pedido pedido;

    private String descricao;

    private BigDecimal precoUnitario;

    private Long quantidade;

}
