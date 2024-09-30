package com.test.test.controller;

import com.test.test.request.ComplaintData;
import com.test.test.request.ComplaintRequest;
import com.test.test.response.Response;
import com.test.test.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/complaint")
@Slf4j
@RequiredArgsConstructor
public class ComplaintController {

    private final ComplaintService service;

    @PostMapping("")
    public ResponseEntity<Response<String>> saveComplaint(@RequestBody ComplaintRequest request){
        return ResponseEntity.ok(new Response<>(service.saveComplaint(request)));
    }

    @GetMapping
    public ResponseEntity<Response<List<ComplaintData>>> getAllComplaintList(){
        return ResponseEntity.ok(new Response<>(service.getAllComplaintList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ComplaintData>> getComplaintById(@PathVariable("id") Long id){
        return ResponseEntity.ok(new Response<>(service.getComplaintById(id)));
    }

    @GetMapping("/ticket/{ticket-no}")
    public ResponseEntity<Response<ComplaintData>> getComplaintByTicketNo(@PathVariable("ticket-no") String ticketNo){
        return ResponseEntity.ok(new Response<>(service.getComplaintByTicketNo(ticketNo)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<String>> closeComplaint(@PathVariable("id") Long id){
        return ResponseEntity.ok(new Response<>(service.closeComplaint(id)));
    }
}
