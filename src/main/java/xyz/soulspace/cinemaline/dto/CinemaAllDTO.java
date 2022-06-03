package xyz.soulspace.cinemaline.dto;

import lombok.*;

@Data
@Builder
public class CinemaAllDTO {
    private String cinemaName;
    private String cinemaAddr;
    private String cinemaImg;
    private String cinemaTel;
    private String service;
}
