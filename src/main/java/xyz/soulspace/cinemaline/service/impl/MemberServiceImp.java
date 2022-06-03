package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Member;
import xyz.soulspace.cinemaline.mapper.MemberMapper;
import xyz.soulspace.cinemaline.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Service
public class MemberServiceImp extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
