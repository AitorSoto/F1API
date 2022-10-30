package com.f1.records.pojos.DAOs;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
public class StatusDAO implements Serializable {
    @Id
    @Column(name = "statusId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private String status;

    public StatusDAO(int statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public StatusDAO() {
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
