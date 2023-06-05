package org.fasttrackit.budget;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Getter
@Builder
public class Transaction {

    private final int id;
    private final String product;
    private final type type;
    private final double amount;
}
