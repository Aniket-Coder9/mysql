package com.test.test.service;

import com.test.test.entity.Complaint;
import com.test.test.enums.Frequency;
import com.test.test.enums.Priority;
import com.test.test.enums.Status;
import com.test.test.manager.ComplaintManager;
import com.test.test.request.ComplaintData;
import com.test.test.request.ComplaintRequest;
import com.test.test.utils.TicketNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplaintService {

    private final ComplaintManager complaintManager;

    public String saveComplaint(ComplaintRequest request) {
        try{
            if (Objects.nonNull(request)) {
                String code;
                do {
                    code = TicketNumberGenerator.generateRandomString();
                } while (complaintManager.findByTicketNo(code).isPresent());
                Complaint complaint = Complaint.builder()
                        .ticketNo(code)
                        .dateTime(new Date())
                        .status(Objects.nonNull(request.getStatus()) ? Status.getByValue(request.getStatus()) : null)
                        .frequency(Objects.nonNull(request.getFrequency()) ? Frequency.getByValue(request.getFrequency()) : null)
                        .priority(Objects.nonNull(request.getPriority()) ? Priority.getByValue(request.getPriority()) : null)
                        .issue(Objects.nonNull(request.getIssue()) ? request.getIssue() : null)
                        .moduleName(Objects.nonNull(request.getModuleName()) ? request.getModuleName() : null)
                        .subModuleName(Objects.nonNull(request.getSubModuleName()) ? request.getSubModuleName() : null)
                        .projectName(Objects.nonNull(request.getProjectName()) ? request.getProjectName() : null)
                        .build();
                complaintManager.save(complaint);
                return "Success";
            }
            return "Fail";
        } catch (Exception e) {
            log.info("Error : {} ", e);
        }
        return "Failed";
    }

    public List<ComplaintData> getAllComplaintList() {
        try {
            List<Complaint> complaintList = complaintManager.findAll();
            List<ComplaintData> complaintDataList = new ArrayList<>();
            if (Objects.nonNull(complaintList)){
                for (Complaint complaint : complaintList) {
                    ComplaintData complaintData = ComplaintData.of(complaint);
                    complaintDataList.add(complaintData);
                }
            }
            return complaintDataList;
        } catch (Exception e) {
            log.info("Error : {} ", e);
        }
        return null;
    }

    public ComplaintData getComplaintById(Long id) {
        try {
            Complaint complaint = complaintManager.findById(id);
            if (Objects.nonNull(complaint)){
                ComplaintData complaintData = ComplaintData.of(complaint);
                return complaintData;
            }
            return null;
        }catch (Exception e){
            log.info("Error : {}", e);
        }
        return null;
    }

    public ComplaintData getComplaintByTicketNo(String ticketNo) {
        try {
            Optional<Complaint> complaint = complaintManager.findByTicketNo(ticketNo);
            if (complaint.isPresent()){
                ComplaintData complaintData = ComplaintData.of(complaint.get());
                return complaintData;
            }
            return null;
        }catch (Exception e){
            log.info("Error : {}", e);
        }
        return null;
    }

    public String closeComplaint(Long id) {
        try {
            Complaint complaint = complaintManager.findById(id);
            if (Objects.nonNull(complaint)){
                complaint.setStatus(Status.CLOSED);
                complaintManager.save(complaint);
                return "Complaint Closed";
            }
            return "No data Found";
        } catch (Exception e) {
            log.info("Error : {} ", e);
        }
        return "Failed";
    }
}
