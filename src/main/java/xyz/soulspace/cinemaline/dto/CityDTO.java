package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {
    private int id;
    private String city;
}
