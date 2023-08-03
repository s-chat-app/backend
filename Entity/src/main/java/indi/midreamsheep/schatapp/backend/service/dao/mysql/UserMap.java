package indi.midreamsheep.schatapp.backend.service.dao.mysql;

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
public class UserMap {
    @TableId("id")
    private long id;
    @TableField("user_0")
    private long user0;
    @TableField("user_1")
    private long user1;
}
