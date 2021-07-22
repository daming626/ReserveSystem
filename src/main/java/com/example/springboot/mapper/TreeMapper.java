package com.example.springboot.mapper;

import com.example.springboot.bean.Tree;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TreeMapper {
    Tree getTreeByRoleId(String roleId);
    Tree getChildTrees(String parenttreeId);
}
