package com.example.demo.domain.seedwork;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 领域模型中Entity的父类.<br/>
 * 每个Entity都必须有标识,标识具有唯一性.<br/>
 * 如果需要领域模型的扩展操作,则需要让IdEntity继承COLA的EntityObject.<br/>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class IdEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
