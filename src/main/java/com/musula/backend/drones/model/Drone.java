package com.musula.backend.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The Class User.
 */
@Entity(name = "Drone")
@Table(name = "Drone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drone implements Serializable {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userID;


    /**
     * The email.
     */
    @Column(name = "Email")
    private String email;

    /**
     * The email confirmed should be null.
     */
    @Column(name = "EmailConfirmed")
    private Boolean emailConfirmed;


    @Column(name = "AccessFailedCount")
    private Long accessFailedCount;


    @Column(name = "LastLoginTime")
    private LocalDateTime lastLoginTime;


    /**
     * The firstname.
     */
    @Column(name = "FirstName")
    private String firstName;

    /**
     * The lastname.
     */
    @Column(name = "LastName")
    private String lastName;


    /**
     * The active.
     */
    @Column(name = "ContactStatusID")
    private Integer contactStatusID;


    /**
     * The password.
     */
    @Column(name = "PasswordHash")
    private String password;

    @NotNull
    @Column(name = "TwoFactorEnabled")
    private Boolean twoFactorEnabled = Boolean.FALSE;

    /**
     * The last status change date.
     */
    @Column(name = "LastStatusChangeDate")
    private LocalDateTime lastStatusChangeDate;

    /**
     * The creation date.
     */
    @Column(name = "CreationDate")
    private LocalDateTime creationDate;

    /**
     * The creation date.
     */
    @Column(name = "UserAgreementGracePeriodEndDate")
    private LocalDateTime userAgreementGracePeriodEndDate;

    /**
     * The creation date.
     */
    @Column(name = "TwoFactorGracePeriodEndDate")
    private LocalDateTime twoFactorGracePeriodEndDate;
    /**
     * The updated by.
     */
    @Column(name = "UpdatedBy")
    private String updatedBy;

    /**
     * The suspend reason.
     */
    @Column(name = "SuspendReason")
    private String suspendReason;
    @Transient
    private String token;


    @Column(name = "Secret")
    private String secret;
    @Column(name = "TwoFactorVerified")
    private Boolean twoFactorVerified;
    @Column(name = "PortalAccess", nullable = false, columnDefinition = "bit default 1")
    private Boolean portalAccess;


}
