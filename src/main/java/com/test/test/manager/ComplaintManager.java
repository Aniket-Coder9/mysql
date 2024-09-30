package com.test.test.manager;
import com.test.test.entity.Complaint;
import com.test.test.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ComplaintManager {

    private final ComplaintRepository complaintRepository;

    public void save(Complaint complaint) {
       complaintRepository.save(complaint);
    }

    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    public Complaint findById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    public Optional<Complaint> findByTicketNo(String code){
        return complaintRepository.findByTicketNo(code);
    }


}
