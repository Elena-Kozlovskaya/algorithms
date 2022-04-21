package com.kozlovskaya.algorithms.homework.lesson6;

public class HomeWorkTest {
    public static void main(String[] args) {

        int notBalanced = 0;

        for(int i = 0; i < 20; i++ ){
            TreeImpl<Integer> homeTree = new TreeImpl<>();
            while (homeTree.getLevel() < 4) {
                homeTree.add(getRandom(-25, 25));
            }

            if(!TreeImpl.isBalanced(homeTree.getRoot())){
                notBalanced ++;
            }
            System.out.println(TreeImpl.isBalanced(homeTree.getRoot()));
        }
        System.out.println((notBalanced/0.2)  + "% trees are not balanced");

    }

    public static int getRandom(int min, int max){
        max-= min;
        return (int) (Math.random() * ++max) + min;
    }
}
