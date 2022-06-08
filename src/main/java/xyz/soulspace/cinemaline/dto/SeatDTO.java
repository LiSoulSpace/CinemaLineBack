package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SeatDTO {
    private List<List<Integer>> seatMsg;
}
