package xyz.soulspace.cinemaline.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FilmTempDTO {
    private String title;
    private String filmImg;
    private String area;
    private String duration;
    private LocalDateTime years;
    private String description;
    private BigDecimal score;
    private int income;
}
