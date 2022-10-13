package SortingGenericType;
import java.util.ArrayList;

public class App {

    private static <E> void swap(ArrayList<E> arrayList, int i, int j){
        E temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(i));
        arrayList.set(j, temp);
    }

    public <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList){
        for(int i = arrayList.size() - 1; i > 0 ; i--){
            for(int j = 0; j < i; i ++){
                if(arrayList.get(j).compareTo(arrayList.get(j+1)) > 0){
                    swap(arrayList, i, j);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList, int start, int end){
        if(end - start <= 1) return;
        int mid = (start + end) / 2;

        mergeSort(arrayList, start, mid);
        mergeSort(arrayList, mid, end);
        merge(arrayList, start, mid, end);
    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> arrayList, int start, int mid, int end){
        int i = start, j = mid;
        
        ArrayList<E> arrayList2 = new ArrayList<>(end - start);
        while(i < mid && j < end){
            if(arrayList.get(i).compareTo(arrayList.get(j))<= 0){
                arrayList2.add(arrayList.get(i));
                i++;
            }else{
                arrayList2.add(arrayList.get(j));
                j++;
            }
        }

        while(i < mid){
            arrayList2.add(arrayList.get(i));
        
        }
        while(j < end){
            arrayList2.add(arrayList.get(j));
        }
    }
}

