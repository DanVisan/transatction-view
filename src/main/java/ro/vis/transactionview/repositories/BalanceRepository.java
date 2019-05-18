package ro.vis.transactionview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vis.transactionview.entities.Balance;

public interface BalanceRepository extends JpaRepository<Balance, String> {

}
