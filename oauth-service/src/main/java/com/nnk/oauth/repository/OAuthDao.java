package com.nnk.oauth.repository;

import com.nnk.oauth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class OAuthDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        grantedAuthoritiesList.add(new SimpleGrantedAuthority("LOGON"));
        String userSQLQuery = "SELECT * FROM jpatest.USERS WHERE USERNAME=?";
        List<UserEntity> list = jdbcTemplate.query(userSQLQuery, new String[] { username },
                (ResultSet rs, int rowNum) -> {

                    UserEntity user = new UserEntity();
                    user.setUsername(username);
                    user.setPassword(rs.getString("PASSWORD"));
                    String role = rs.getString("ROLE");
                    if(role != null){
                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                        grantedAuthoritiesList.add(grantedAuthority);
                        user.setGrantedAuthoritiesList(grantedAuthoritiesList);
                    }
                    return user;
                });
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
