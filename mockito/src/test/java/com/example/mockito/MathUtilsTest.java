package com.example.mockito;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MathUtilsTest {

  @Test
 public void add(){
    MathUtils mathUtils = mock(MathUtils.class);
//    MathUtils mathUtils1 = new MathUtils();
    when(mathUtils.add(1,1)).thenReturn(2);
    assertEquals(2,mathUtils.add(1,1));

    ArgumentCaptor acInteger = ArgumentCaptor.forClass(Integer.class);
//    verify(mathUtils).add(acInteger.capture(),acInteger.capture());
  }

  @Test
  public void whenNotUseMockAnnotation_thenCorrect() {
    List mockList = Mockito.mock(ArrayList.class);

    mockList.add("one");
    verify(mockList).add("one");
    assertEquals(0, mockList.size());

    Mockito.when(mockList.size()).thenReturn(100);
    assertEquals(100, mockList.size());
  }

  @MockBean
  List<String> mockList;

  @Test
  public void whenNotUseMockBeanAnnotation_thenCorrect() {

    mockList.add("one");
    verify(mockList).add("one");
    assertEquals(0, mockList.size());

    Mockito.when(mockList.size()).thenReturn(100);
    assertEquals(100, mockList.size());
  }

  @Test
  public void whenNotUseCaptorAnnotation_thenCorrect() {
    List mockList = Mockito.mock(List.class);
    ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

    mockList.add("one");
    mockList.add("twe");
    verify(mockList,times(2)).add(arg.capture());

//    assertEquals("one", arg.getValue());
    List<String> res = arg.getAllValues();
    res.stream().forEach(x->System.out.println(x));
  }

}

