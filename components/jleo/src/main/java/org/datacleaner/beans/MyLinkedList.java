package org.datacleaner.beans;

/**
 * @Description 该类是
 * @Author LeoDY
 * @Date 2021/4/27
 **/
public class MyLinkedList {
    int size;
    ListNode head;// 作为伪头的哨兵节点

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode pre = head;
        for(int i = 0; i < index ; ++i) {
            if (size >1) pre = pre.next;
        }
        return pre.val;
    }
    public void addAtHead(int val) {
        size++;
        ListNode cur  = new ListNode(val);
        if (size == 1){
            head = cur;
        }else {
            cur.next = head;
            head = cur;
        }
    }
    public void addAtTail(int val) {
        if (size==0){
            addAtHead(val);
            return;
        }
        ListNode cur = new ListNode(val);
        ListNode prev = head ;
        for (int i = 1; i < size; i++) {
            prev = prev.next;
        }
        prev.next = cur;
        size++;
    }
    public void addAtIndex(int index,int val) {
        if (index > size){
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        if (index <= 0){
            addAtHead(val);
            return;
        }
        if (index >0 && index < size){
            ListNode cur = new ListNode(val);
            ListNode prev = head ;
            for (int i = 1; i < index; i++) {
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            size++;
            return;
        }
    }

    public void deleteAtIndex(int index) {
        if (index<0 || index >= size || size==0){return;}
        if (size >=1){
            ListNode pre = head;
            if (index==0){
                if (pre.next != null){pre = pre.next;head = pre;}
                else {pre.val=0;}
            }else if (index==1){
                if (pre.next.next == null){pre.next = null;}
                else {
                    pre.next = pre.next.next;
                }
            }else {
                for (int i = 1; i < index; i++) {
                    pre = pre.next;
                }
                if (pre.next.next == null){
                    pre.next = null;
                }else {
                    pre.next = pre.next.next;
                }
            }
        }
        size--;
        return;
    }

    @Override
    public String toString() {
        String result = "MyLinkedList{";
        for (int i = 0; i < size; i++) {
            result = result.concat(get(i)+",");
        }
        result = result.substring(0,result.length()-1).concat("}");
        return  result;
    }
}
