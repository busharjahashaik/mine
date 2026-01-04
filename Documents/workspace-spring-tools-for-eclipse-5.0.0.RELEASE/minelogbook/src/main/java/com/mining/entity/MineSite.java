package com.mining.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "minesite")
public class MineSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mineId")
    private int mineId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // Optional: List of workers
    @OneToMany(mappedBy = "mineSite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Worker> workers;

    public enum Status {
        ACTIVE, INACTIVE
    }

    // constructors, getters, setters
    public MineSite() {}

    public MineSite(String name, String location, Status status) {
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public int getMineId() { return mineId; }
    public void setMineId(int mineId) { this.mineId = mineId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<Worker> getWorkers() { return workers; }
    public void setWorkers(List<Worker> workers) { this.workers = workers; }
}
