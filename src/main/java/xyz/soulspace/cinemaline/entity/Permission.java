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
 * 权限表
 * </p>
 *
 * @author soulspace
 * @since 2022-06-04 10:32:57
 */
@Getter
@Setter
@TableName("ums_permission")
public class Permission extends Model<Permission> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名字
     */
    @TableField("permission_name")
    private String permissionName;

    /**
     * 权限URI
     */
    @TableField("uri")
    private String uri;

    /**
     * 权限描述
     */
    @TableField("descriptions")
    private String descriptions;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
