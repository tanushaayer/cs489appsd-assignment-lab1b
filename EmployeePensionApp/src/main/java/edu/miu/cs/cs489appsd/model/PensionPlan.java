package edu.miu.cs.cs489appsd.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        return "planReferenceNumber=" + planReferenceNumber + ", enrollmentDate=" + enrollmentDate + ", monthlyContribution=" + monthlyContribution ;
    }
}
