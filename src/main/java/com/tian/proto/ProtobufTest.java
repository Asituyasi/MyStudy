package com.tian.proto;


import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student1 = DataInfo.Student.newBuilder().setName("张三").setAge(12).setAddress("深圳").build();

        byte[] student1Bytes = student1.toByteArray();

        DataInfo.Student student2 = DataInfo.Student.parseFrom(student1Bytes);

        System.out.println(student2.toString());
    }
}
