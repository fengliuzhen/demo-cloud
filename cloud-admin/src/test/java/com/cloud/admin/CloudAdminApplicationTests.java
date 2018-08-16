package com.cloud.admin;

import com.cloud.entity.OrderEntity;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.base.*;
import com.google.common.collect.Sets;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudAdminApplicationTests {

    @Test
    public void contextLoads() {
        String str="1-2-1-5-7-8";
        List<String> strList=Splitter.on("-").splitToList(str);
        String newStr=Joiner.on(",").join(strList);

        String str2="aa,dd,,ff,,,;sdf";
        List<String> strList2=Splitter.onPattern("[,|.]").omitEmptyStrings().splitToList(str2);

        String str3="lkjg89dfd3";
        String newStr2=CharMatcher.digit().retainFrom(str3);

        Set<Integer> list= Sets.newHashSet(1,2,3,5,6);
        Set<Integer> list1= Sets.newHashSet(4,5,6,7);

        Sets.SetView<Integer> set1=Sets.union(list,list1);
        Sets.SetView<Integer> set2= Sets.difference(list,list1);
        Sets.SetView<Integer> set3= Sets.intersection(list,list1);
        //是否为空
        if(Strings.isNullOrEmpty(str3))
        {

        }

        Preconditions.checkArgument(list.size()>0,"");

        Stopwatch stopwatch=Stopwatch.createStarted();
        OrderEntity orderEntity=new OrderEntity(1,"q123456789");
        String str22=MoreObjects.toStringHelper(OrderEntity.class).add("age",orderEntity.getAge()).toString();
        long longtime=stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("耗时："+longtime+"毫秒");
    }

}
