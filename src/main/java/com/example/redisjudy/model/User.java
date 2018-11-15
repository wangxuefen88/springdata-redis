package com.example.redisjudy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @param
 * @Author: judy
 * @Description:
 * @Date: Created in 9:01 2018/11/15
 */
@Data
@AllArgsConstructor
public class User {
        private  String id;
        private  String name;
        private String sex;
        private String nation;
        private  long epochSecond;
    }
