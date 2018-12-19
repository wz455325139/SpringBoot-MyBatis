package com.thumbup.model.entity;

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
public class AuthEntity extends BaseEntity {

    private Long id;
    private String apikey;
    private String delFlag;
    private LocalDateTime lastAccessDate;

}
