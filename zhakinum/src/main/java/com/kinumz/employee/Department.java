package com.kinumz.employee;

import com.kinumz.common.model.Company;
import java.util.Map;

public class Department {

    private Long id;

    private String name;

    private String description;

    private Company company;

    public String generateToken() {
        Map<String, String> claims = Map.of("id", "user.getId().toString()",
                                            "role", "user.getRole()");
        return "";
    }

}
