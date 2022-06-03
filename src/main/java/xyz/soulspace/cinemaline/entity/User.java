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
 * 用户表
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Getter
@Setter
@TableName("ums_user")
public class User extends Model<User> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("username")
    private String username;

    @TableField("password_u")
    private String passwordU;

    @TableField("nickname")
    private String nickname;

    @TableField("avatar_md5")
    private String avatarMd5;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
