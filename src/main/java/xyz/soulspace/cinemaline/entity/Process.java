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
 * 
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:50:31
 */
@Getter
@Setter
@TableName("main_process")
public class Process extends Model<Process> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("film_id")
    private Long filmId;

    @TableField("cinema_id")
    private Long cinemaId;

    @TableField("cost")
    private BigDecimal cost;

    @TableField("start_time")
    private LocalDateTime startTime;

    @TableField("room_name")
    private String roomName;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
