package model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {
    private String orderId;
    private LocalDate orderDate;
    private String customerId;
}
