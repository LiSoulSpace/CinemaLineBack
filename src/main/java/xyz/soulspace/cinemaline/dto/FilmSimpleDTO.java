package xyz.soulspace.cinemaline.dto;

import lombok.*;

@Data
@Builder
public class FilmSimpleDTO {
    private int id;
    private String title;
    private double score;
    private String filmImg;
}
