package com.example.util;

import com.example.config.CustomDetails;
import com.example.entity.LibrarianEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    public static Long getCurrentLibrarianId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomDetails user = (CustomDetails) authentication.getPrincipal();
        return user.librarian().getId();
    }

    public static LibrarianEntity getCurrentLibrarian() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomDetails user = (CustomDetails) authentication.getPrincipal();
        return user.librarian();
    }
}


