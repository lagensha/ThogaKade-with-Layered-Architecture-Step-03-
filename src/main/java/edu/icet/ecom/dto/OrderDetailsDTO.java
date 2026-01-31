package edu.icet.ecom.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class OrderDetailsDTO {
    private String orderId;
    private String itemCode;
    private int qty;
    private int discount;
}
