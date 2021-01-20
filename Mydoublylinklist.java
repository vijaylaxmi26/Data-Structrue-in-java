
public class Mydoublylinklist {

    Node head;

    static class Node {

        int data;
        Node next;
        Node pre;

        public Node(int data) {
            this.data = data;
            next = null;
            pre = null;
        }

    }

    public void insert(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        new_node.pre = temp;
        temp.next = new_node;
    }

    public int count() {
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insert(int position, int data) {
        Node new_node = new Node(data);
        if (position < 0 || position > count()) {
            System.out.println("Invalid opration");
        }
        if (count() == 0) {
            insert(data);
            return;
        }
        if (position == 0) {
            head.pre=new_node;
            new_node.next = head;
            head = new_node;
            return;
        }
        Node temp = head;
        int count = 0;
        while (count != position - 1) {
            temp = temp.next;
            count++;
        }
        new_node.next = temp.next;
        new_node.pre = temp;
        temp.next = new_node;
        new_node.next.pre = new_node;

    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public void print_reverse() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp.next != null) {
             System.out.println(temp.data);
            temp = temp.pre;
        }
               
    }
    
    public void delet() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }
    
     public void delet(int position) {
        if (position == 0) {
            head = head.next;
            head.pre=null;
            return;
        }
        Node temp = head;
        int count = 0;
        while (count != position - 1) {
            temp = temp.next;
            count++;
        }
        
        temp.next = temp.next.next;
        temp.next.pre=temp;
        
    }
     
      public void sort() {

        Node temp1, temp2;
        temp1 = head;
        while (temp1 != null) {
            temp2 = temp1;
            while (temp2 != null) {
                if (temp1.data > temp2.data) {
                    int temp = temp1.data;
                    temp1.data = temp2.data;
                    temp2.data = temp;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

    }
     
    public static void main(String[] args) {
            MyLinklist list = new MyLinklist();
        list.insert(5);
        list.insert(6);
        list.insert(10);
        list.insert(39);
        list.insert(24);
        list.insert(12);
        list.print();
              
        System.out.println("----------------------------------------------------");
        list.insert(1, 23);
        list.print();

        list.delet();
        System.out.println("----------------------------------------------------");
        list.print();
        
        list.delet(4);
        System.out.println("----------------------------------------------------");
        list.print();

        list.sort();
        System.out.println("----------------------------------------------------");
        list.print();
    }

}
