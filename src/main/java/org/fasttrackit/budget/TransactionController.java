package org.fasttrackit.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("{id}")
    public Transaction getById(@PathVariable long id){
        return transactionService.getTransactionWithId(id);
    }
    @PostMapping
    public Transaction addNewTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }
    @PutMapping
    public Transaction updateTransactionWithId( @PathVariable long id, @RequestBody Transaction transaction){
        return transactionService.update(transaction, id);

    }

    @DeleteMapping("/{id}")
    public Transaction deleteById(@PathVariable long id){
        return transactionService.delete(id);
    }


}
