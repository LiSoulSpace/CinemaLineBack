package xyz.soulspace.cinemaline.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class BuyTicketDTO {
    private int orderId;
    private String title;
    private String duration;
    private String room;
    private String showTime;
    private List<Integer> col;
    private List<Integer> row;
    private double cost;
    private String qrcode;
}
