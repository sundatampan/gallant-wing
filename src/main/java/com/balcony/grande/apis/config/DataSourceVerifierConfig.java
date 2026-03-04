package com.balcony.grande.apis.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Configuration
public class DataSourceVerifierConfig {

    @Bean
    ApplicationRunner verifyDataSource(DataSource dataSource) {
        return args -> {
            try (Connection c = dataSource.getConnection()) {
                DatabaseMetaData md = c.getMetaData();
                String url = md.getURL();
                String user = md.getUserName();
                // Do NOT log the password
                System.out.println("[DataSourceVerifier] URL=" + url + ", user=" + user);
                // Optional: confirm DB identity
                try (var st = c.createStatement();
                     var rs = st.executeQuery("select current_user, current_database()")) {
                    if (rs.next()) {
                        System.out.println("[DB Identity] current_user=" + rs.getString(1) +
                                ", current_database=" + rs.getString(2));
                    }
                }
            }
        };
    }
}
