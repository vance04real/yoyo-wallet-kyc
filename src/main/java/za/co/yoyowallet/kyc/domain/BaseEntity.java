package za.co.yoyowallet.kyc.domain;


import za.co.yoyowallet.kyc.utils.enums.EntityStatus;
import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created  25/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public abstract class BaseEntity {

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "date_last_updated")
    private LocalDateTime dateLastUpdated;

    @Version
    private Long version;


    protected void prePersist() {
        if(creationDate == null) {
            creationDate = LocalDateTime.now();
        }

        if(status == null) {
            status = EntityStatus.ACTIVE;
        }
    }

    protected void preUpdate() {
        dateLastUpdated = LocalDateTime.now();
    }
}
