package com.mining.entity;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private int workerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String role;

    // Add MineSite relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mineId", nullable = false) // FK column in Worker table
    private MineSite mineSite;

    // Getters and Setters
    public int getWorkerId() { return workerId; }
    public void setWorkerId(int workerId) { this.workerId = workerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public MineSite getMineSite() { return mineSite; }
    public void setMineSite(MineSite mineSite) { this.mineSite = mineSite; }
}
