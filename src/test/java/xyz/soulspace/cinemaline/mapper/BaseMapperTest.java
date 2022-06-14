package xyz.soulspace.cinemaline.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.soulspace.cinemaline.dto.CinemaAllDTO;
import xyz.soulspace.cinemaline.dto.CinemaSimpleDTO;
import xyz.soulspace.cinemaline.dto.FilmAllDTO;
import xyz.soulspace.cinemaline.dto.FilmTempDTO;
import xyz.soulspace.cinemaline.entity.FilmTag;

import java.util.List;

@Slf4j
@SpringBootTest
public class BaseMapperTest {
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    CinemaMapper cinemaMapper;
    @Autowired
    FilmTagMapper filmTagMapper;

    @Test
    void testCinemaSample(){
        List<CinemaSimpleDTO> dtos = cinemaMapper.selectAllByCityNameAndFilmId("威海", 1L);
        log.warn(String.valueOf(dtos));
        List<CinemaSimpleDTO> cinemaSimpleDTOS = cinemaMapper.selectAllByCityNameAndFilmId(null, 1L);
        log.warn(cinemaSimpleDTOS.toString());
    }

    @Test
    void testGetCinemaById(){
        List<CinemaAllDTO> cinemaAllDTOS = cinemaMapper.selectCinemaAllDTOById(1L);
        log.warn(cinemaAllDTOS.get(0).toString());
    }

    @Test
    void testFilmInfo(){
        FilmTempDTO filmAllDTO = filmMapper.selectFAllById(1L);
        log.warn(filmAllDTO.toString());
    }

    @Test
    void testFilmTag(){
        List<FilmTag> filmTags = filmTagMapper.selectTagById(1L);
        filmTags.forEach(filmTag -> {
            log.warn(filmTag.toString());
        });
    }
}
