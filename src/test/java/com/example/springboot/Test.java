package com.example.springboot;

import com.example.springboot.mapper.ReservingMapper;
import com.example.springboot.service.IReservingServise;
import com.example.springboot.service.impl.ReservingService;
import org.apache.ibatis.io.ResolverUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@MapperScan("com.example.springboot.mapper")
@Service
public class Test {

    @Autowired
    private IReservingServise reservingServise;

    @org.junit.jupiter.api.Test
    public void test(){
        String[] a =new ReservingMapper() {
            @Override
            public String[] getAllRoomId() {
                return reservingServise.getAllRoomId();
            }
        }.getAllRoomId();

        for (int i=1;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    @org.junit.jupiter.api.Test
    public void f(){
        String[] kk=reservingServise.getAllRoomId();
        for (String a:kk){
            System.out.println(a);
        }
    }
}
