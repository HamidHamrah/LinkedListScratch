import java.util.Scanner;

public class DlinkedList {
    public class Node{
        int value;
        Node next;
        Node prev;

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next, Node prev) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }
    Node head;
    Node tail;


    public void insertFørst(int value){
        Node current=new Node(value);
        current.next=head;
        current.prev=null;
        if (head!=null){
            head.prev=current;
        }
        head=current;
    }
    public void insertLast(int value){
        Node current=new Node(value);
       if (head==null){
           head=tail=current;
           head.prev=null;
           tail.next=null;
           return;
       }
       else {
           tail.next=current;
           current.prev=tail;
           tail=current;
           tail.next=null;
       }

    }
    public void Print(){
        Node current=head;
        Node last=null;
        while (current!=null){
            System.out.print(current.value+"-->");
            last=current;
            current=current.next;
        }
        System.out.println("End");
        while (last!=null){
            System.out.print(last.value+"-->");
            last=last.prev;
        }
        System.out.print("End");
    }

 /*
    public void Reversprinting(){
        Node current=tail;
        while (current!=null){
            System.out.println(current.value+"-->");
            current=current.prev;
        }
        System.out.println("End");
    }
*/
}
