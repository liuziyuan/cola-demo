package com.example.demo.domain.aggregate.seedwork;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * If the action of the domain model needs to be extended, you need to let the Entity inherit EntityObject of COLA.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity extends IdEntity {

    protected String creator;
    protected String modifier;
    protected Timestamp createTime;
    protected Timestamp modifiedTime;

    public void setBaseInfo(String operator, BaseOperationType baseOperationType){
        Timestamp current = new Timestamp(new Date().getTime());
        switch (baseOperationType){
            case SAVE:
                this.creator = operator;
                this.modifier = operator;
                this.createTime = current;
                this.modifiedTime = current;
                break;
            case UPDATE:
                this.modifier = operator;
                this.modifiedTime = current;
                break;
            default:
                break;
        }
    }

}
