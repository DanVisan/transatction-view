package ro.vis.transactionview.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    private long id;
    private String sender;
    private String receiver;
    private double value;
    private String currency;
    private String message;
    private String timestamp;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"sender\":\"" + sender + "\"," +
                "\"receiver\":\"" + receiver + "\"," +
                "\"value\":" + value + "," +
                "\"currency\":\"" + currency + "\"," +
                "\"message\":\"" + message + "\"," +
                "\"timestamp\":\"" + timestamp + "\"" +
                "}";
    }
}
