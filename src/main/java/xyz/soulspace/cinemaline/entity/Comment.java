package xyz.soulspace.cinemaline.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author soulspace
 * @since 2022-06-01 05:07:20
 */
@Getter
@Setter
@TableName("ums_comment")
public class Comment extends Model<Comment> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("user_id")
    private Long userId;

    @TableField("film_id")
    private Long filmId;

    @TableField("content")
    private String content;

    @TableField("score")
    private Integer score;

    @TableField("thumb_num")
    private Integer thumbNum;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
