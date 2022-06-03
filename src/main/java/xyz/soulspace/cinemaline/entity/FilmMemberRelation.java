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
@TableName("fms_film_member_relation")
public class FilmMemberRelation extends Model<FilmMemberRelation> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("film_id")
    private Long filmId;

    @TableField("member_id")
    private Long memberId;

    @TableField("is_director")
    private Integer isDirector;

    @TableField("is_actor")
    private Integer isActor;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
