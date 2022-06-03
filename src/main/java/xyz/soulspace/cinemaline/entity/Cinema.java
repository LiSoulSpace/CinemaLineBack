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
 * 影院表
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:02:14
 */
@Getter
@Setter
@TableName("main_cinema")
public class Cinema extends Model<Cinema> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("city_id")
    private Long cityId;

    @TableField("cinema_name")
    private String cinemaName;

    @TableField("address")
    private String address;

    @TableField("telephone")
    private String telephone;

    @TableField("service_info")
    private String serviceInfo;

    @TableField("img_md5")
    private String imgMd5;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
