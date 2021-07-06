package struct;

import java.util.function.DoublePredicate;

public class DoubleLikedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1,"tan","hang");
        HeroNode2 hero2 = new HeroNode2(2, "hang", "tan");
        HeroNode2 hero3 = new HeroNode2(3,"123","456");
        HeroNode2 hero4 = new HeroNode2(4, "ppp", "qqq");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

//        doubleLinkedList.showList();
//
//        System.out.println("-------------------删除");
//        doubleLinkedList.del(2);
//        doubleLinkedList.showList();
//
//        System.out.println("--------------------修改");
//        HeroNode2 newHero = new HeroNode2(3,"354","453ooo");
//        doubleLinkedList.update(newHero);
//        doubleLinkedList.showList();


        System.out.println("-------------------orderByNo");
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.showList();

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

    //    在添加英雄时，根据排名插入到指定位置，如果有这个排名，则添加失败
    public void addByOrder(HeroNode2 heroNode) {
//        因为头节点不能动，所以通过一个辅助变量来帮助找到添加的位置

//        HeroNode2 temp = head;
//        boolean flag = false; //标志添加的编号是否存在，默认为false
//        while (true) {
//            if (temp.next == null) {    //说明到了链表的最后
//                break;
//            }
//            if (temp.next.no > heroNode.no) {  //位置找到，就在temp后面插入
//                break;
//            } else if (temp.next.no == heroNode.no) { //说明希望添加的heroNode编号已经存在
//                flag = true;
//                break;
//            }
//            temp = temp.next; //后移，遍历当前链表
//        }
////        判断flag的值
//        if (flag) {
//            System.out.println("准备插入的英雄的编号" + heroNode.no + "已经存在，不能加入");
//        } else {
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }

        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (heroNode.no < temp.next.no) {
                break;
            } else if (heroNode.no == temp.next.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            System.out.println("------------结点已经存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
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
        heroNode.pre = temp;
    }

//修改
    public void update(HeroNode2 heroNode) {
//        判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
//        找到需要修改的节点，定义一个辅助变量
        HeroNode2 temp = head.next;
//        表示是否找到该节点
        boolean flag = false;

        while (true) {
//            到了链表的最后,已经遍历完了
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

//        根据flag判断是否找到需要修改的节点
        if (flag = true) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到编号" +  heroNode.no + "的节点");
        }
    }


    //    删除节点
    public void del(int no) {
        if (head.next == null) {
            return;
        }
        HeroNode2 temp = head.next;
//        是否找到待删除节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) { //已经到链表的最后了
                break;
            }
            if (temp.no == no) {
//                找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next; //temp向后移,遍历
        }
        if (flag) { //找到节点
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("要删除的节点" + no + "不存在");
        }
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
