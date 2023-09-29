package indi.midreamsheep.schatapp.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Group Table Structure
 * @author lsk
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("group")
public class DaoGroup {
    /**Group ID Generated with snowflake*/
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    /**Group Name*/
    @TableField("group_name")
    private String groupName;
    /**Group Owner*/
    @TableField("group_owner")
    private long groupOwner;
    /**Group Data*/
    @TableField("group_data")
    private String groupData;
    /**Group State*/
    @TableField("group_state")
    private int group_state;
    /**Create Time*/
    @TableField("create_time")
    private Timestamp createTime;

}
