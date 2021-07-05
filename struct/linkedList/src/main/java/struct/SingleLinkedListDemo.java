package struct;

import sun.plugin.WJcovUtil;

import java.lang.reflect.WildcardType;
import java.util.LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"tan","hang");
        HeroNode hero2 = new HeroNode(2, "hang", "tan");
        HeroNode hero3 = new HeroNode(3,"123","456");
        HeroNode hero4 = new HeroNode(4, "ppp", "qqq");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        System.out.println("---------------------原本的数据-----------------");
        singleLinkedList.showList();
//        System.out.println("----------------------");
//        HeroNode newHero = new HeroNode(2, "qqq", "ppp");
//
//        singleLinkedList.update(newHero);
//        singleLinkedList.showList();

//        System.out.println("---------");
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.showList();

        System.out.println("---------获取节点的个数---------");
        System.out.println(singleLinkedList.getNodeNumCount(singleLinkedList.getHead()));

        System.out.println("----------根据k获取反方向索引的数据-----------");
        System.out.println(singleLinkedList.getNodeByIndex(singleLinkedList.getHead(), 1));

        System.out.println("----------------------反转-----------------");
        singleLinkedList.reverseHeroNode(singleLinkedList.getHead());
        singleLinkedList.showList();
    }
}

//定义singleLinkedList来管理英雄人物
class SingleLinkedList {

//    先初始化头节点,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

//    单链表的反转
    public void reverseHeroNode(HeroNode heroNode) {
//        如果原始链表为空或者只有一个节点，无须循环
        if (head == null || head.next.next == null) {
            return;
        }
//        定义一个新的链表，用于存储反转之后的数据
        HeroNode reverse = new HeroNode(0, "", "");
//        定义一个临时变量，用于之后的操作 从第一个节点开始
        HeroNode temp = heroNode.next;
//        指向当前节点的下一个节点
        HeroNode next = null;

//        将每次循环到的数据都放在heroNode.next的位置
//        如果为空，证明链表已经循环完成
        while (temp != null) {
//            第一次：
//                  temp在上面已经拿了第一个节点 这里的next指向的是第二个节点，保存到next里面
//            第二次：
//                  temp现在指向的是第三个节点，保存到next里面
//        暂时先保存temp的下一个节点
            next = temp.next;
//            第一次：
//                  reverse是新链表，里面无数据，置空temp.next
//            第二次：
//                  因为经过第一次遍历，reverse已经被赋予了一个节点，所以这里的next指向的是第二个节点的位置，赋值给temp.next
//        将temp的下一个节点指向新的链表的最前端
            temp.next = reverse.next;
//              将temp连接到新的链表上
//            第一次：
//                  把第一个节点赋值给reverse.next  预留出 一个位置给reverse放头节点
//            第二次:
//                  把第二个节点赋值给reverse.next
            reverse.next = temp;
//            让temp移到下一个节点
//            第一次：
//                  这里next保存的是第二个节点，赋值给temp 所以现在temp= temp.next的值
//            第二次：
//                  指向的是第三个节点，赋值给temp
            temp = next;

        }
//        System.out.println(head.next +"    " +reverse.next);
        head.next = reverse.next;

    }

//    查找单链表中的第k个节点
    public HeroNode getNodeByIndex(HeroNode heroNode,int index) {
        if (heroNode == null) {
            return null;
        }
//        遍历节点
        int size = getNodeNumCount(heroNode);
        if (index <= 0 || index>size) {
            return null;
        }
//        定义一个辅助变量,for循环到index的位置
        HeroNode temp = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
//    计算单链表节点的个数
    public int getNodeNumCount(HeroNode node) {

        if (node.next == null) {
            return 0;
        }

        int length = 0;
//        定义一个辅助变量
        HeroNode temp =node.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //    添加节点到单向链表
    public void add(HeroNode heroNode) {
//        思路，当不考虑编号的顺序时，找到当前链表的最后节点，将最后这个节点的next域指向新的节点
//        因为头节点不能动，因此需要一个辅助变量 temp
        HeroNode temp = head;
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

//    删除节点
    public void del(int no) {
        HeroNode temp = head;
//        是否找到待删除节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) { //已经到链表的最后了
                break;
            }
            if (temp.next.no == no) {
//                找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) { //找到节点
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点" + no + "不存在");
        }
    }

//    在添加英雄时，根据排名插入到指定位置，如果有这个排名，则添加失败
    public void addByOrder(HeroNode heroNode) {
//        因为头节点不能懂，所以通过一个辅助变量来帮助找到添加的位置
//        因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {    //说明到了链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {  //位置找到，就在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明希望添加的heroNode编号已经存在
                flag = true;
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }

//        判断flag的值
        if (flag) {
            System.out.println("准备插入的英雄的编号" + heroNode.no + "已经存在，不能加入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //    修改节点的信息，根据编号来修改，编号不能更改
    public void update(HeroNode heroNode) {
//        判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
//        找到需要修改的节点，定义一个辅助变量
        HeroNode temp = head.next;
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

//    显示链表
    public void showList() {
//        先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
//        头节点不能动，因此需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName) {
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