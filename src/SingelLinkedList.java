public class SingelLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SingelLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    private class Node{
       private int value;
       private Node next;
       private Node pre;

       public Node(int value) {
           this.value = value;
       }

       public Node(int value, Node next) {
           this.value = value;
           this.next = next;
           this.pre=pre;

       }

    }
   public  void InsertFørst(Integer verdi){
        Node current=new Node(verdi);
        current.next=head;
        head=current;
        if (tail==null){
            tail=head;
        }
        size++;
   }
   public void InsertLast(Integer verdi){
        if (tail==null){
            InsertFørst(verdi);
            return;
        }
       Node Current=new Node(verdi);
       tail.next=Current;
       tail=Current;
       size++;
   }
   public void Insert(int indeks, int verdi){
        if (indeks==0){
            InsertFørst(verdi);
            return;
        }
        if (indeks==size){
            InsertLast(verdi);
            return;
        }
        Node current=head;
        for (int i=1; i<indeks; i++){
            current=current.next;
        }
        Node node=new Node(verdi,current.next);
        current.next=node;
        size++;
   }
   public int fjernførste(){
        int val= head.value;
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return val;
   }
   public Node getRef(int indeks){
        Node current=head;
       for (int i = 0; i <indeks ; i++) {
           current=current.next;
       }
       return current;
   }
   public int fjernesiste(){
         if (size<=1){
             return fjernførste();
         }
         Node secondelast=getRef(size-2);
         int val=tail.value;
         tail=secondelast;
         tail.next=null;
        return val;
   }
    public int fjernet(int indeks){
        if (indeks<=1){
            return fjernførste();
        }
        if (indeks==size){
            return fjernesiste();
        }
        Node curret=head;
        Node prev=getRef(indeks-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }
    public Node find(int value){
        Node current=head;
        while (current!=null){
            if (current.value==value){
                return current;
            }
        }
        current=current.next;
        return null;
    }


   public void print(){
        Node current=head;
       for (int i=0; i<size; i++){
           System.out.print(current.value+"-->");
           current=current.next;
       }

       System.out.println("End");
   }

}

