package com.shawn.model.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseEntity {

    private String createUser;

    private LocalDateTime createDate;

    private String updateUser;

    private LocalDateTime updateDate;

    public BaseEntity(String createUser, LocalDateTime createDate) {
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = createUser;
        this.updateDate = createDate;
    }

}
