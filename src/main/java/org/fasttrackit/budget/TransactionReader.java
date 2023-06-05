package org.fasttrackit.budget;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TransactionReader {
    public List<Transaction> readTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/file.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                transactions.add(fromLine(line));
            }
        }catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        return transactions;


        }
        private Transaction fromLine(String  line){
        String[] tokens = line.split("//|");
        Transaction.TransactionBuilder transactionBuilder = Transaction.builder()
                .id(Integer.parseInt(tokens[0]))
                .product(tokens[1])
                .type(type.valueOf(tokens[2]))
                .amount(Double.parseDouble(tokens[3]));

            return transactionBuilder.build();
        }


}
