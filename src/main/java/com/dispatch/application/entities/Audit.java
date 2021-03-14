package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Audit")
@Scope("session")
public class Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int audit_id;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** @ManyToOne
    @JoinColumn(name = "Id")
    private User user;
**/
    private String audit_event;

    public String getAudit_event() {
        return audit_event;
    }

    public void setAudit_event(String audit_event) {
        this.audit_event = audit_event;
    }

    private Date date_created;

    private Date  time_created;

    public int getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(int audit_id) {
        this.audit_id = audit_id;
    }

   /**  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
**/
    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public Date getTime_updated() {
        return time_updated;
    }

    public void setTime_updated(Date time_updated) {
        this.time_updated = time_updated;
    }

    private Date  date_updated;
    private Date  time_updated;

    private boolean showStatus;

    public boolean isShowStatus() {
        return showStatus;
    }

    public void setShowStatus(boolean showStatus) {
        this.showStatus = showStatus;
    }
}
