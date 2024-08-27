package org.example.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static <T> void swap(List<T> inputList, int indexA, int indexB){
        T temp = inputList.get(indexA);
        inputList.set(indexA, inputList.get(indexB));
        inputList.set(indexB, temp);
    }

    public static List<Integer>getRandomList(){
        return getRandomList(10, 1, 100);
    }

    public static List<Integer> getRandomList(int listSize, int min, int max){
        Random random = new Random();
        List<Integer> output = new ArrayList<>();
        for(int i=0; i <= listSize; i++){
            output.add(random.nextInt(max - min) + min) ;
        }
        return output;
    }


}
