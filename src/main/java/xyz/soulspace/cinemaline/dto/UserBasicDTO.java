package xyz.soulspace.cinemaline.dto;

import lombok.*;

@Data
@Builder
public class UserBasicDTO {
    private int UserId;
    private String nickName;
    private String avatar;
}
