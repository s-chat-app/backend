package indi.midreamsheep.schatapp.backend.dao.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Group;
import org.apache.ibatis.annotations.Mapper;

/**
 * Accesses the group table
 * @author lsk
 */
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
}
