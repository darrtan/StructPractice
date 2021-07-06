package struct;

public class DoubleLikedListDemo {
    public static void main(String[] args) {

    }
}


class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

//    遍历双向链表
//    显示链表
public void showList() {
//        先判断链表是否为空
    if (head.next == null) {
        System.out.println("链表为空");
        return;
    }
//        头节点不能动，因此需要辅助变量来遍历
    HeroNode2 temp = head.next;
    while (true) {
        if (temp == null) {
            break;
        }
        System.out.println(temp);
        temp = temp.next;
    }

}

    public void add(HeroNode2 heroNode) {
//        思路，当不考虑编号的顺序时，找到当前链表的最后节点，将最后这个节点的next域指向新的节点
//        因为头节点不能动，因此需要一个辅助变量 temp
        HeroNode2 temp = head;
//        遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
//            如果没找到，将temp后移
            temp = temp.next;
        }
//        当退出while循环时，temp指向链表的最后
        temp.next = heroNode;
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; //指向上一个节点

    public HeroNode2(int no,String name,String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
