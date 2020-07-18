package instance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Slf4j
@Configuration
public class LeafConfiguration
{

    @Bean
    public void segmentIDGen() throws SQLException
    {

    }

}
