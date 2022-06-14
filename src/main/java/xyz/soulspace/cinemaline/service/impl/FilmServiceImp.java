package xyz.soulspace.cinemaline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.dto.FilmAllDTO;
import xyz.soulspace.cinemaline.dto.FilmSimpleDTO;
import xyz.soulspace.cinemaline.dto.FilmTempDTO;
import xyz.soulspace.cinemaline.dto.MemberDTO;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.entity.FilmTag;
import xyz.soulspace.cinemaline.mapper.FilmMapper;
import xyz.soulspace.cinemaline.mapper.FilmTagMapper;
import xyz.soulspace.cinemaline.mapper.MemberMapper;
import xyz.soulspace.cinemaline.service.FilmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 * 电影表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:34:09
 */
@Service
public class FilmServiceImp extends ServiceImpl<FilmMapper, Film> implements FilmService {

    @Autowired
    FilmMapper filmMapper;
    @Autowired
    FilmTagMapper filmTagMapper;
    @Autowired
    MemberMapper memberMapper;

    @Override
    public Film getFilmById(Long id) {
        return filmMapper.selectById(id);
    }

    @Override
    public FilmAllDTO getFilmAllById(Long id) {
        FilmTempDTO filmTempDTO = filmMapper.selectFAllById(id);
        if (filmTempDTO == null) return null;
        FilmAllDTO filmAllDTOTemp = new FilmAllDTO();
        FilmAllDTO filmAllDTO = filmAllDTOTemp.fromFilmTempDTO(filmTempDTO);
        List<FilmTag> filmTags = filmTagMapper.selectTagById(id);
        List<String> tags = new CopyOnWriteArrayList<>();
        if (filmTags.size() > 0) {
            filmTags.forEach(filmTag -> {
                tags.add(filmTag.getTag());
            });
        }
        filmAllDTO.setTags(tags);
        List<MemberDTO> memberDTOS = memberMapper.selectAllById(id);
        filmAllDTO.setPeople(memberDTOS);
        return filmAllDTO;
    }

    @Override
    public List<FilmSimpleDTO> getAll() {
        return filmMapper.selectAll();
    }
}
