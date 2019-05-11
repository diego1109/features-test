package com.johnny.chapter2.main;

import com.johnny.chapter2.mapper.RoleMapper;
import com.johnny.chapter2.po.Role;
import com.johnny.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter2Main {

  private static Logger logger = LogManager.getLogger(Chapter2Main.class.getName());

  public static void main(String[] args) {

    //我的施恩哦按常见病呢
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
      Role role = new Role("name3", "note");
//            roleMapper.insertRole(role);
//            roleMapper.deleteRole(1L);
      Role res = roleMapper.getRole(7L);
      System.out.println(res.getNote() + "\t" + res.getRoleName());
      sqlSession.commit();
    } catch (Exception e) {
      System.err.println(e.getMessage());
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }
    logger.info("执行成功!");
  }
}