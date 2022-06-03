package xyz.soulspace.cinemaline.datainput;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.soulspace.cinemaline.entity.*;
import xyz.soulspace.cinemaline.mapper.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class DataInputTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ImgInfoMapper imgInfoMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    CinemaMapper cinemaMapper;
    @Autowired
    FilmTagMapper filmTagMapper;
    @Autowired
    AreaInfoMapper areaInfoMapper;
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    FilmMemberRelationMapper filmMemberRelationMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void addUsers() {
        User user = new User();
        user.setUsername("admin");
        String encode = passwordEncoder.encode("123456");
        log.warn(encode);
        user.setPasswordU(encode);
        user.setNickname("admin");
        user.setAvatarMd5("test_md5");
        userMapper.insert(user);
    }

    @Test
    public void addImgInfo() {
        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setImgMd5("test_md5");
        imgInfo.setImgUrl("/test/url/img/00001");
        imgInfoMapper.insert(imgInfo);
    }

    @Test
    public void addCityInfo() {
        City city = new City();
        city.setCityName("威海");
        city.setInitialChar("W");
        cityMapper.insert(city);
    }

    @Test
    public void addCinema() {
        Cinema cinema = new Cinema();
        cinema.setCinemaName("新世纪电影城（长春路店）");
        cinema.setAddress("环翠区长春路帝王宫昌鸿广场5楼（近帝王宫）");
        cinema.setCityId(cityMapper.selectIdByCityName("威海").get(0).getId());
        cinema.setImgMd5("test_md5");
        cinema.setTelephone("1234567890");
        cinema.setServiceInfo("基本观影服务");
        cinemaMapper.insert(cinema);
    }

    @Test
    public void addFilm() {
        Film film = new Film();
        film.setFilmName("哆啦A梦：大雄的宇宙小战争 2021");
        film.setDuration(109 * 60);
        film.setIsShow(1);
        film.setScore(new BigDecimal("8.4"));
        film.setIncome(41030000L);
        film.setReleaseTime(LocalDateTime.of(2022, Month.MAY, 28, 8, 0, 0));
        film.setAreaId(areaInfoMapper.selectIdByArea("日本").get(0).getId());
        film.setDescriptionF("大雄意外结识拇指外星人帕比，在哆啦A梦的帮助下，与大家一起穿越星际共同去守护匹里卡星，并开展了一段奇妙的宇宙冒险。");
        filmMapper.insert(film);
    }

    @Test
    public void addTags() {
        List<String> tagList = new ArrayList<>();
        tagList.add("爱情");
        tagList.add("喜剧");
        tagList.add("动画");
        tagList.add("科幻");
        tagList.add("动作");
        tagList.add("武侠");
        tagList.forEach(s -> {
            FilmTag filmTag = new FilmTag();
            filmTag.setTag(s);
            filmTagMapper.insert(filmTag);
        });
    }

    @Test
    public void addAreas() {
        List<String> areaList = new ArrayList<>() {{
            add("大陆");
            add("美国");
            add("韩国");
            add("日本");
            add("中国香港");
            add("中国台湾");
            add("泰国");
            add("印度");
        }};
        areaList.forEach(s -> {
            AreaInfo areaInfo = new AreaInfo();
            areaInfo.setArea(s);
            areaInfoMapper.insert(areaInfo);
        });
    }

    @Test
    public void addMembers() {
        List<String> memberList = new ArrayList<>() {{
            add("哆啦A梦");
            add("山口晋");
            add("大雄");
        }};
        memberList.forEach(s -> {
            Member member = new Member();
            member.setMemberName(s);
            member.setImageMd5("test_md5");
            memberMapper.insert(member);
        });
    }

    @Test
    public void addMemberFileRe(){
        FilmMemberRelation filmMemberRelation = new FilmMemberRelation();
        filmMemberRelation.setFilmId(1L);
        filmMemberRelation.setMemberId(1L);
        filmMemberRelation.setIsDirector(0);
        filmMemberRelation.setIsActor(1);
        filmMemberRelationMapper.insert(filmMemberRelation);
        filmMemberRelation = new FilmMemberRelation();
        filmMemberRelation.setFilmId(1L);
        filmMemberRelation.setMemberId(3L);
        filmMemberRelation.setIsDirector(0);
        filmMemberRelation.setIsActor(1);
        filmMemberRelationMapper.insert(filmMemberRelation);
        filmMemberRelation = new FilmMemberRelation();
        filmMemberRelation.setFilmId(1L);
        filmMemberRelation.setMemberId(2L);
        filmMemberRelation.setIsDirector(1);
        filmMemberRelation.setIsActor(0);
        filmMemberRelationMapper.insert(filmMemberRelation);
    }
}
