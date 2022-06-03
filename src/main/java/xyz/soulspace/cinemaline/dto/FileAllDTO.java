package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FileAllDTO {
    private String title;
    private String filmImg;
    private List<String> tags;
    private String area;
    private String duration;
    private String years;
    private String description;
    private double score;
    private int income;
    private List<MemberDTO> people;
    private List<CommentDTO> comments;
}
