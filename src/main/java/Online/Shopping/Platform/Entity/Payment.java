package Online.Shopping.Platform.Entity;

import lombok.Data;

@Data
public class Payment {
    private double amount;
    private String currency;
    private String status;
}
