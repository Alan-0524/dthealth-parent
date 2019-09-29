package com.dthealth.safe.config;

import com.dthealth.dao.entity.User;
import com.dthealth.dao.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepositoryService repositoryService;

    @Override
    public UserDetails loadUserByUsername(@NonNull String userAccount) throws UsernameNotFoundException{
        User user = repositoryService.findByUserAccount(userAccount);
        StringBuilder stringBuilder = new StringBuilder(user.getFirstName());
        if (!StringUtils.isEmpty(user.getMiddleName())) {
            stringBuilder.append(" ").append(user.getMiddleName());
        }
        stringBuilder.append(" ").append(user.getLastName());
        user.setFullName(stringBuilder.toString());
        String shownGender = user.getGender().equals("0")?"female":"male";
        user.setShownGender(shownGender);
        user.setAge("30");
        return new SecureUser(user);
    }
}
