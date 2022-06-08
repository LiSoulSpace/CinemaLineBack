package xyz.soulspace.cinemaline.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BuyTicketDTO {
    private Long orderId;
    private String title;
    private int duration;
    private String room;
    private LocalDateTime showTime;
    private List<Integer> col;
    private List<Integer> row;
    private BigDecimal cost;
    private String qrcode;
}
