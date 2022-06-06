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
 * @since 2022-06-06 10:50:31
 */
@Getter
@Setter
@TableName("sms_seat_info")
public class SeatInfo extends Model<SeatInfo> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("process_id")
    private Long processId;

    /**
     * 行数
     */
    @TableField("row_num")
    private Integer rowNum;

    @TableField("column_num")
    private Integer columnNum;

    @TableField("seat_arrangement")
    private String seatArrangement;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
