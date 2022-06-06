package xyz.soulspace.cinemaline.dto;

import lombok.Data;

@Data
public class CinemaSimpleDTO {
    private String cinemaId;
    private String cinemaName;
    private String cinemaAddr;
    private String cinemaImg;
    private double cost;
}
