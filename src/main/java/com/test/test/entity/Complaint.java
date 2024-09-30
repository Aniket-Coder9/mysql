package com.test.test.entity;

import com.test.test.enums.Frequency;
import com.test.test.enums.Priority;
import com.test.test.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "complaint")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_no", unique = true)
    private String ticketNo;

    @Column(name = "date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "sub_module_name")
    private String subModuleName;

    @Column(name = "issue")
    private String issue;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "frequency")
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
