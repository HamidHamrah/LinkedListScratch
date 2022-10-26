import java.util.IllegalFormatCodePointException;

public class DlinkedList {
    private int size;

    public DlinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public class Node{
        int value;
        Node next;
        Node prev;


        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next, Node prev, int size) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }

        public int getSize() {
            return size;
        }
    }
    Node head;
    Node tail;

// Here we are going insert a node in the as a first element in the linkedlist.
    public void insertFørst(int value){
        Node current=new Node(value);
        current.next=head;
        current.prev=null;
        if (head!=null){
            head.prev=current;
        }
        head=current;
        size++;

    }
    // Here we are going Insert a node in as a last element in the linkedlist.
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
       size++;

    }

    // Here we are going to inesrt an element at a spesfic indeks
    // The way it works is the that we will be give a number an we will try to insert it in the middel of an element.
    public void insertIndeks(int after, int value){
        Node p=findNode(after);
        if (p==null){
            System.out.println("Den eksister ikke");
            return;
        }
        Node node=new Node(value);
        node.next=p.next;
        node.prev=p;
        p.next=node;
        if (node.next!=null){
        node.next.prev=node;
        }
    }
    public Node findNode(int after){
        Node current=head;
        while (current!=null){
            if (current.value==after){
                return current;
            }
            current=current.next;
        }
        return null;
    }

    public boolean Delet(int number){
        Node p=findNode(number);
        if (p.prev==null){
            p.next.prev=null;
            return true;
        }
        if (p.next==null){
            p.prev.next=null;
            return true;
        }else{
            p.prev.next=p.next;
            p.next.prev=p.prev;
            return true;
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
    public int finIndeks(int val){
        Node node=head;
        int indeks=0;
        while (node!=null){
            if (node.value==val){
                return indeks;
            }
            indeks++;
            node=node.next;
        }
        return -1;
    }
    public boolean innholder(int value){
        Node node=head;
        while (node!=null){
            if (node.value==value){
                return true;
            }
            node=node.next;
        }
        return false;
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
