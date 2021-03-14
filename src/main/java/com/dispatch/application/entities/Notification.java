package com.dispatch.application.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Notification")
@Scope("session")
public class Notification implements Serializable {



        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id ;

        private int notificationFrom;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getNotificationFrom() {
                return notificationFrom;
        }

        public void setNotificationFrom(int notificationFrom) {
                this.notificationFrom = notificationFrom;
        }

        public int getNotificationTo() {
                return notificationTo;
        }

        public void setNotificationTo(int notificationTo) {
                this.notificationTo = notificationTo;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public Audit getAudit() {
                return audit;
        }

        public void setAudit(Audit audit) {
                this.audit = audit;
        }

        private int notificationTo;

        private String message;

        @OneToOne(cascade = CascadeType.ALL)
        private Audit audit;
}
