package com.cache.redis.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String name;
    private String rollNumber;

}
