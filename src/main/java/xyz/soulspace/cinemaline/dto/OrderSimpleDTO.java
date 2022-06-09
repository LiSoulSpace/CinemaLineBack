package xyz.soulspace.cinemaline.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderSimpleDTO {
    Long orderId;
    String title;
    String filmImg;
    int duration;
    String room;
    LocalDateTime showTime;
    String seatInfo;
    BigDecimal cost;
    String qrcode;
    String cinemaName;
}
