package indi.midreamsheep.schatapp.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("user_mapper")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DaoUserMap {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("user_0")
    private long user0;
    @TableField("user_1")
    private long user1;
}
