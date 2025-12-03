package model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String code;
    private String description;
    private String packSize;
    private Double unitPrice;
    private int qtyOnHand;
}
