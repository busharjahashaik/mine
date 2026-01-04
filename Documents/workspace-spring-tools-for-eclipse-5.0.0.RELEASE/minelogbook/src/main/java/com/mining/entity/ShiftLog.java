package com.mining.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Shiftlog")
public class ShiftLog {

    @Id
    private int shiftId;
    private int mineId;

    @Temporal(TemporalType.DATE)
    private Date shiftDate;

    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;

    private int supervisorId;

    public enum ShiftType {
        DAY, NIGHT
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }
}