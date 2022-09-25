package com.f1.records.pojos;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private String status;

    public Status(int statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public Status() {
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
