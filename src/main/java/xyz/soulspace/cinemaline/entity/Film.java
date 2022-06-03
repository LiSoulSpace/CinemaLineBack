package xyz.soulspace.cinemaline.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 电影表
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:34:09
 */
@Getter
@Setter
@TableName("main_film")
public class Film extends Model<Film> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 电影名字
     */
    @TableField("film_name")
    private String filmName;

    /**
     * 是否正在上映
     */
    @TableField("is_show")
    private Integer isShow;

    /**
     * 上市时间
     */
    @TableField("release_time")
    private LocalDateTime releaseTime;

    /**
     * 票房
     */
    @TableField("income")
    private Long income;

    /**
     * 评分
     */
    @TableField("score")
    private BigDecimal score;

    /**
     * 秒单位
     */
    @TableField("duration")
    private Integer duration;

    /**
     * 电影描述
     */
    @TableField("description_f")
    private String descriptionF;

    @TableField("area_id")
    private Long areaId;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
