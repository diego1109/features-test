package soundsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class StgPeppersTest {
  @Autowired
  private CompactDisc cd;

  @Autowired
  private User user;

  @Test
  public void cdShouldNotBeNull(){
    assertNotNull(cd);
  }

  @Test
  public void userShouldNotBeNull(){
    assertNotNull(user);
  }
}