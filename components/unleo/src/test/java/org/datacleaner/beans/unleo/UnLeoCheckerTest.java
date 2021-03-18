package org.datacleaner.beans.unleo;/**
 * @author Leo
 * @description 干嘛干嘛的
 * @date 2019/9/5 17:53
 **/

import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author 10648
 * @Date 2021年1月20日
 **/
public class UnLeoCheckerTest extends TestCase {
    @Test
    public void testZJmonth(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String day = format.format(d);
        System.out.println("过去七天："+day);

        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);

        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        String mon3 = format.format(m3);
        System.out.println("过去三个月："+mon3);
    }

    @Test
    public void testThreemonth(){
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        String mon3 = dateFormat.format(m3);
        System.out.println("过去三个月："+mon3);
        ArrayList<Object> list = new ArrayList<>();
        do {
            Date nextDay = getNextDay(m3);
            String nextDayStr = dateFormat.format(nextDay);
            System.out.println("下一天是："+nextDayStr);
            m3 = nextDay;
            list.add(nextDayStr);
        }while (m3.before(new Date()));
        System.out.println("总共有："+list.size());

        if (new Date().before(new Date())){
            System.out.println("===hahahah");
        }
    }

    public Date getNextDay(Date day){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DAY_OF_MONTH,1);
        Date nextDay = c.getTime();
        return nextDay;
    }
}
