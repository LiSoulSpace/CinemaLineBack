package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Comment;
import xyz.soulspace.cinemaline.mapper.CommentMapper;
import xyz.soulspace.cinemaline.service.CommentService;
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
public class CommentServiceImp extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
