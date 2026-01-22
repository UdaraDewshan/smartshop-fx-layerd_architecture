package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItem {
    private String itemCode;
    private String description;
    private int qty;
    private double unitPrice;
    private double discount;
    private double total;
}
