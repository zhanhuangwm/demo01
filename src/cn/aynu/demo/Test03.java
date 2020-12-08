package cn.aynu.demo;

import cn.aynu.pojo.DcodeDto;

public class Test03 {
    public static void main(String[] args) {
        DcodeDto dcodeDto = new DcodeDto();
        dcodeDto.setCodeCode("123");
        DcodeDto newDcodeDto = dcodeDto;
        dcodeDto.setCodeCode("456");
        System.out.println(newDcodeDto.getCodeCode());
    }
}
