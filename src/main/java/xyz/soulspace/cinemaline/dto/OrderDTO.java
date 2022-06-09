package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * "orderId": 11111,
 * "title": "",
 * "filmImg": "",
 * "duration": "",
 * "room": "",
 * "showTime": "",
 * "col": [],
 * "row": [],
 * "cost": 2.0,
 * "qrcode": "base64"
 */
@Data
public class OrderDTO {
    Long orderId;
    String title;
    String filmImg;
    int duration;
    String room;
    LocalDateTime showTime;
    List<Integer> col;
    List<Integer> row;
    BigDecimal cost;
    String qrcode;
    String cinemaName;

    public void setFromSimple(OrderSimpleDTO simpleDTO) {
        this.setOrderId(simpleDTO.getOrderId());
        this.setTitle(simpleDTO.getTitle());
        this.setFilmImg(simpleDTO.getFilmImg());
        this.setDuration(simpleDTO.getDuration());
        this.setRoom(simpleDTO.getRoom());
        this.setShowTime(simpleDTO.getShowTime());
        this.setCost(simpleDTO.getCost());
        this.setQrcode(simpleDTO.getQrcode());
        this.setCinemaName(simpleDTO.getCinemaName());
    }
}
