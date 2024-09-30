package com.test.test.request;

import com.test.test.entity.Complaint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintData {

    private long id;
    private String ticketNo;
    private String projectName;
    private String moduleName;
    private String subModuleName;
    private String issue;
    private String priority;
    private String frequency;
    private String status;

    public static ComplaintData of(Complaint complaint) {
        if(Objects.isNull(complaint)){
            return null;
        }
        ComplaintData data = new ComplaintData();
        data.setId(complaint.getId());
        data.setTicketNo(complaint.getTicketNo());
        data.setProjectName(Objects.nonNull(complaint) ? complaint.getProjectName() : null);
        data.setModuleName(Objects.nonNull(complaint) ? complaint.getModuleName() : null);
        data.setSubModuleName(Objects.nonNull(complaint) ? complaint.getSubModuleName() : null);
        data.setIssue(Objects.nonNull(complaint) ? complaint.getIssue() : null);
        data.setPriority(Objects.nonNull(complaint) ? complaint.getPriority().toString() : null);
        data.setFrequency(Objects.nonNull(complaint) ? complaint.getFrequency().toString() : null);
        data.setStatus(Objects.nonNull(complaint) ? complaint.getStatus().toString() : null);
        return data;
    }
}
