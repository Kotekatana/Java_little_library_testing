package ru.inno.ec.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderForm {
    public String userId;
    public String bookId;
}
