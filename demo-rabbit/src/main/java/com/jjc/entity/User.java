package com.jjc.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import org.springframework.amqp.core.Message;

import java.io.Serializable;

/**
 * Created by jjc on 2019/6/24.
 */
@Data
public class User implements Serializable {
    private String id;
    private String name;
}
