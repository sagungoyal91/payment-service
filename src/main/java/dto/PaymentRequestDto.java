package dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDto {

    private String reservationId;
    private String customerId;
    private BigDecimal amount;
    private String method;
}

