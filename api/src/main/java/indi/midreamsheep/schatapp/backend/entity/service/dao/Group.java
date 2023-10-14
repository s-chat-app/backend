package indi.midreamsheep.schatapp.backend.entity.service.dao;

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
public class Group {
    /**Group ID Generated with snowflake*/
    private long id;
    /**Group Name*/
    private String groupName;
    /**Group Owner*/
    private long groupOwner;
    /**Group Data*/
    private String groupData;
    /**Group State*/
    private int group_state;
    /**Create Time*/
    private Timestamp createTime;

}
