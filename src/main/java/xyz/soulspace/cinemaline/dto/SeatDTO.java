package xyz.soulspace.cinemaline.dto;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class SeatDTO {
    private List<List<Integer>> seatMsg;

    public String seatsToString() {
        return "{\"seatMsg\":" + seatMsg.toString() + "}";
    }

    public void setLocation(int row, int col, int target) {
        this.seatMsg.get(row).set(col, target);
    }
}
