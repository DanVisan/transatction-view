package ro.vis.transactionview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vis.transactionview.entities.Balance;
import ro.vis.transactionview.models.TransactionModel;
import ro.vis.transactionview.repositories.BalanceRepository;

import java.util.Objects;

@Service
public class BalanceService {

    private BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(final BalanceRepository balanceRepository) {
        this.balanceRepository = Objects.requireNonNull(balanceRepository, "balanceRepository must not be null!");
    }

    public void updateBalance(final TransactionModel transactionModel) {
        Balance balance = balanceRepository.findOne(transactionModel.getReceiver());
        if (balance != null) {
            double newBalanceValue = balance.getBalance() + transactionModel.getValue();
            Balance newBalance = Balance.builder()
                    .userId(balance.getUserId())
                    .balance(newBalanceValue)
                    .lastUpdated(transactionModel.getTimestamp())
                    .build();
            balanceRepository.save(newBalance);
        }
    }
}
