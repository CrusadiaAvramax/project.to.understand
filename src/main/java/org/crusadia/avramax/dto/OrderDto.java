package org.crusadia.avramax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crusadia.avramax.enumerations.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {


    private Integer idUser;

    private LocalDateTime orderDate;

    private OrderStatus status; // es. PENDING, CONFIRMED, SHIPPED, CANCELLED

    private BigDecimal totalAmount;

    private List<Integer> idItems;
}
