package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ShowTimeDTO {
    private int showId;
    private LocalDateTime showTime;
    private double cost;
    private String room;
    private String cinemaName;
}

