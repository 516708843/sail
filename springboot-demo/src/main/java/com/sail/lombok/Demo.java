package com.sail.lombok;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
//@RequiredArgsConstructor(access = AccessLevel.PROTECTED,staticName = "test")
@AllArgsConstructor
/** 
* @Description:  Demo
* @Author: 魏凡
* @Date: 2018/10/10 
*/ 
public class Demo
{
    @NonNull
    public int age;
    public String name;
    @NonNull
    protected String color;
}
