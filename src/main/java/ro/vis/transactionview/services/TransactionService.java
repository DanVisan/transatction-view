package ro.vis.transactionview.services;

import org.springframework.stereotype.Service;
import ro.vis.transactionview.models.Transaction;

@Service
public class TransactionService {

    private static double SUM = 0.0;

    public void intercept(final Transaction transaction) {
        SUM += transaction.getValue();
        System.out.println(SUM);
    }
}
