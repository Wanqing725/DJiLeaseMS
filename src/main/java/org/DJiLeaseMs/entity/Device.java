package org.DJiLeaseMs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    private String model;

    private String color;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @Column(name = "daily_rent")
    private BigDecimal dailyRent;

    private String status;

    @Column(name = "last_check_time")
    private LocalDateTime lastCheckTime;

    @Column(name = "check_notes")
    private String checkNotes;

    @Column(name = "insurance_date")
    private LocalDateTime insuranceDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}