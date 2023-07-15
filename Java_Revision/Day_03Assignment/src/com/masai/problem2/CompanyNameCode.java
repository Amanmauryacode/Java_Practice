package com.masai.problem2;

import java.util.HashMap;
import java.util.Map;

public final class CompanyNameCode {

    final static Map<String,String> companyCode;

    static {
        companyCode = new HashMap<>();

        companyCode.put("EKP","Ekoplay");
        companyCode.put("EXP","Explore");
        companyCode.put("FSK","Funskool");
        companyCode.put("NKT","Natkhat");
        companyCode.put("SLD","Sunlord");
        companyCode.put("TZN","ToyZone");
    }

}
