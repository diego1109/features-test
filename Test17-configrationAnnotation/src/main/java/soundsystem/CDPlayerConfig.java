package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CDConfig.class,User.class})
public class CDPlayerConfig {

  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc){
    return new CDPlayer(compactDisc);
  }

}
