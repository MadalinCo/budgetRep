package org.fasttrackit.budget;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;




@Component
@RequiredArgsConstructor

public class TransactionService {
    /*private final List<Transaction> transactionList = List.of(
            new Transaction(1,"aa", type.SELL, 2),
            new Transaction(2,"bb",type.SELL,5),
            new Transaction(3,"cc",type.BUY,7),
            new Transaction(4,"dd", type.BUY, 222)

    );*/
    private final TransactionReader transactionReader;
    private final List<Transaction> transactionList = new ArrayList<>();

    public void transactionTransfer(){
        System.out.println("Post construct in Transaction Service");
        transactionList.addAll(transactionReader.readTransactions());

    }




    public List<Transaction> getAllTransactions() {
        return transactionList;
    }


    public Transaction getTransactionWithId(long id) {
        return getAllTransactions().stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Transaction addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        return transaction;
    }

    public Transaction delete(long id){
        Transaction transaction = getTransactionWithId(id);
        transactionList.remove(transaction);
        return transaction;

    }
   /* public Transaction update(Transaction transaction, long id){
        Transaction existingTransaction = delete(id);
        return add(Transaction.builder())
                .id(id)
                .product
    }



    public Country update(Country country, long id) {
        Country existingCountry = delete(id);
        return add(Country.builder()
                .id(id)
                .name(existingCountry.getName())
                .neighbours(existingCountry.getNeighbours())
                .capital(country.getCapital())
                .population(country.getPopulation())
                .area(country.getArea())
                .continent(existingCountry.getContinent())
                .build());
    }
    */
}