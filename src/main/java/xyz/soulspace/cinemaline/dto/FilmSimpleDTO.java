package xyz.soulspace.cinemaline.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class FilmSimpleDTO {
    private int id;
    private String title;
    private BigDecimal score;
    private String filmImg;
}
