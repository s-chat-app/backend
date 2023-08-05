package indi.midreamsheep.schatapp.backend.service.dao.mysql;

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
public class Group {
    /**
     * Group ID
     * Generated with snowflake
     */
    @TableId(value = "id")
    private Long id;

    /**
     * Group Name
     */
    @TableField("group_name")
    private String groupName;

    /**
     * Group Owner
     */
    @TableField("group_owner")
    private Long groupOwner;

    /**
     * Group Data
     */
    @TableField("group_data")
    private String groupData;

    /**
     * Group State
     */
    @TableField("group_state")
    private Integer group_state;

    /**
     * Create Time
     */
    @TableField("create_time")
    private Timestamp createTime;

}
