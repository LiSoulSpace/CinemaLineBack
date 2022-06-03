package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private String personName;
    private String personImg;
}
