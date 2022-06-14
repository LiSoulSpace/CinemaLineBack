package xyz.soulspace.cinemaline.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmAllDTO {
    private String title;
    private String filmImg;
    private List<String> tags;
    private String area;
    private String duration;
    private LocalDateTime years;
    private String description;
    private BigDecimal score;
    private int income;
    private List<MemberDTO> people;
    private List<CommentDTO> comments;

    public FilmAllDTO fromFilmTempDTO(FilmTempDTO filmTempDTO) {
        FilmAllDTO filmAllDTO = new FilmAllDTO();
        filmAllDTO.setTitle(filmTempDTO.getTitle());
        filmAllDTO.setFilmImg(filmTempDTO.getFilmImg());
        filmAllDTO.setArea(filmTempDTO.getArea());
        filmAllDTO.setDuration(filmTempDTO.getDuration());
        filmAllDTO.setDescription(filmTempDTO.getDescription());
        filmAllDTO.setYears(filmTempDTO.getYears());
        filmAllDTO.setScore(filmTempDTO.getScore());
        filmAllDTO.setIncome(filmTempDTO.getIncome());
        filmAllDTO.setComments(new ArrayList<>());
        return filmAllDTO;
    }
}
