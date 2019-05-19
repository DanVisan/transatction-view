package ro.vis.transactionview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.vis.transactionview.entities.Balance;
import ro.vis.transactionview.services.BalanceService;

import java.util.Objects;

@RestController
public class BalanceController {
    private BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = Objects.requireNonNull(balanceService, "balanceService must not be null!");
    }

    @GetMapping("/balance/{clientId}")
    public ResponseEntity<Balance> getBalanceByClientId(@PathVariable("clientId") final String clientId) {
        Balance balance = balanceService.getBalanceByClientId(clientId);
        if (balance != null) {
            return ResponseEntity.ok(balance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
