package com.test.test.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintRequest {

    private String projectName;
    private String moduleName;
    private String subModuleName;
    private String issue;
    private String priority;
    private String frequency;
    private String status;
}
