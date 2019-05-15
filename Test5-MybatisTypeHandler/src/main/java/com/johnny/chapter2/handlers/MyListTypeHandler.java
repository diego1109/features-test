package com.johnny.chapter2.handlers;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(List.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyListTypeHandler extends BaseTypeHandler<List<String>> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter,
      JdbcType jdbcType) throws SQLException {
    System.out.println("-----0----");
    StringBuffer sb = new StringBuffer();
    for(String string : parameter){
      sb.append(string).append(",");
    }
    System.out.println("i is :"+i+"\t"+"sb:"+sb.toString());

    ps.setString(i,sb.toString().substring(0, sb.toString().length() - 1));
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    System.out.println("-----3----");
    String[] split = rs.getString(columnName).split(",");
    List<String> result = Arrays.asList(split);
    return result;
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    System.out.println("-----2----");
    String[] split = rs.getString(columnIndex).split(",");
    List<String> result = Arrays.asList(split);
    return result;
  }

  @Override
  public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    System.out.println("-----1----");
    String[] split = cs.getString(columnIndex).split(",");
    List<String> result = Arrays.asList(split);
    return result;
  }


}
