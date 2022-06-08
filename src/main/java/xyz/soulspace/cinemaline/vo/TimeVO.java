package xyz.soulspace.cinemaline.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TimeVO {
    private Long filmId;
    private Long cinemaId;
    private BigDecimal cost;
    private LocalDateTime startTime;
    private String roomName;
}
