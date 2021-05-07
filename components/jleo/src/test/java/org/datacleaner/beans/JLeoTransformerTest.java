package org.datacleaner.beans;
import jnr.ffi.Struct;
import org.datacleaner.components.categories.LeoTransCategory;
import org.datacleaner.data.MockInputColumn;
import org.datacleaner.data.MockInputRow;
import org.junit.Test;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * @Description
 * @Author Leo
 * @Date 2021年1月11日14:32:51
 **/
public class JLeoTransformerTest {
    @Test
    public void test1() {
        final MockInputColumn<Date> col = new MockInputColumn<>("haha666", Date.class);

        JLeoTransformer transformer = new JLeoTransformer();
        transformer.setDateColumn(col);

        Date date = new Date();
        String[] result = transformer.transform(new MockInputRow().put(col, date));
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    @Test
    public void test2() {
        System.out.println("===="+new LeoTransCategory().getName());
        final MockInputColumn<String> col = new MockInputColumn<>("Name", String.class);

        final JLeoHelloTransformer transformer = new JLeoHelloTransformer();
        transformer.nameColumn = col;
        transformer.greetings = new String[] { "Hello" };

        assertEquals("Name (greeting)", transformer.getOutputColumns().getColumnName(0));

        assertEquals("Hello Tom", transformer.transform(new MockInputRow().put(col, "Tom"))[0]);
        assertEquals("Hello Martin", transformer.transform(new MockInputRow().put(col, "Martin"))[0]);
        assertEquals("Hello Jesse", transformer.transform(new MockInputRow().put(col, "Jesse"))[0]);
    }
    @Test
    public void test3(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        try {
            Date parse = format.parse("2021-04-15");
            System.out.println(currentDate);
            System.out.println(parse);
            if (currentDate.getTime() >= parse.getTime()){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTi(){
        MyLinkedList obj = new MyLinkedList();
        obj.addAtTail(1);
        System.out.println(obj);
        obj.get(0);
        System.out.println(obj);
    }

    @Test
    public void testTi2(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ListNode resNode = reverseList(node1);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next==null){return head;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode newDummy = getRes(dummy, pre);
        newDummy = newDummy.next;
        return newDummy;
    }

    private ListNode getRes(ListNode dummy, ListNode pre) {
        //如果只有两个节点 互换即可
        if (pre.next.next == null){
            dummy.next = pre.next;
            pre.next = null;
            dummy.next.next = pre;
            return  dummy;
        }
        //三个及三个以上的节点 首先置顶点
        ListNode local = dummy.next;
        ListNode topNode;
        topNode = pre.next;
        topNode.next = dummy.next;
        dummy.next = topNode;
        //裁剪pre
        local = dummy.next;
        while (local != pre){
            local = local.next;
        }
        local.next = pre.next.next;
        pre.next = pre.next.next;
        getRes(dummy,pre);
        return dummy;
    }
}
