package ro.vis.transactionview.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "balances")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Balance {
    @Id
    @Column(name = "user_id")
    private String userId;
    private double balance;
    @Column(name = "last_updated")
    private String lastUpdated;
}