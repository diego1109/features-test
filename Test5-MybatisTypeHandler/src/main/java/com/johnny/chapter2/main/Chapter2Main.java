package com.johnny.chapter2.main;

import com.johnny.chapter2.mapper.RoleMapper;
import com.johnny.chapter2.mapper.UserMapper;
import com.johnny.chapter2.po.Person;
import com.johnny.chapter2.po.Role;
import com.johnny.chapter2.po.User;
import com.johnny.chapter2.util.SqlSessionFactoryUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.tools.tree.NewArrayExpression;

public class Chapter2Main {

  private static Logger logger = LogManager.getLogger(Chapter2Main.class.getName());

  //  测试insertPerson
  public static void test6() {
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      Person p = new Person();
      List<String> list = new ArrayList<String>();
      list.add("足球");
      list.add("篮球");
      list.add("音乐");
      list.add("读书");
      p.setInterest(list);
      userMapper.insertPersion(p);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }
  }

  //测试getPerson
  public static void test7() {
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      List<Person> people = userMapper.getPerson();
      people.stream().forEach(u->System.out.println(u));
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }
  }

  //测试role
  public static void test() {
    //    adnjkanjkkl
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


  public static void test2() {
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      User user = new User();
      user.setPassword("222222");
      user.setUsername("李四");
      Date regTime = new Date();
      user.setRegTime(regTime);
      userMapper.insertUser(user);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }

  }
  //测试typeHandler
  public static void test1() {
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      List<User> list = userMapper.getUser();
      for (User user : list) {
        System.out.println(user);
      }
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }

  }

  //测试resultMap
  public static void test11() {
    SqlSession sqlSession = null;
    try {
      sqlSession = SqlSessionFactoryUtil.openSqlSession();
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      List<User> list = userMapper.getUser2();
      for (User user : list) {
        System.out.println(user);
      }
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }

  }

  public static void main(String[] args) {
//    test6();
//    test7();
//    test();
//    test2();
//    test1();
    test11();
  }

}