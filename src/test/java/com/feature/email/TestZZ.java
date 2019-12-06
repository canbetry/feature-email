package com.feature.email;

import com.feature.email.utils.CommonBeanUtils;

public class TestZZ {

    public static void main(String[] args) {

        String dateTimeStr = "2018-07-28 14:11:15";
        String dateStr = "2018-07-28";
        System.out.println(CommonBeanUtils.dateStrFormatterToDateHMS(dateTimeStr));
    }
}
