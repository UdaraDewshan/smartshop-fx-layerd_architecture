package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private String orderQty;
    private double discount;
}
