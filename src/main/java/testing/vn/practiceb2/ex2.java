package testing.vn.practiceb2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ex2 {
    /*
    give an array ={1,5,7,3,0,9}
    tim phần tử lớn nhất và lớn t2 của một mảng cho trước
     */
    public static void main(String[] args) {
        int[] array={1,5,7,-3,0,9};
        System.out.println("maxArray: "+maxArray(array));
        System.out.println("secondMaxArray: "+secondMaxArray(array));
        System.out.printf("minArray: %d",minArray(array));

        int [] arr = {1,5,7,3,0,9};
        // get min & max value of array
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int[] arr2=Arrays.stream(arr).filter(e -> e<max).toArray();
        int secondMax=Arrays.stream(arr2).max().getAsInt();
        System.out.printf("\nmax: %s\nsecondMax: %s\nmin: %s\n",max,secondMax,min);

        //filter value >=5
        Arrays.stream(arr).filter(e -> e>=5).forEach(System.out::println);
        //for each ? System.out.println(each);
        //filter từ mảng này qua mảng khác, thành 1 array khác
        int[] arr3 = Arrays.stream(arr).filter(e -> e>=5).toArray();
        //tinh tong cac phan tu cua mang
        int total=Arrays.stream(arr).reduce(0,Integer::sum);
        System.out.println("Total: "+total);

        ex1 example1 = new ex1();
        System.out.println("Mang ban dau");
        example1.showArray(arr);
        System.out.println("\nMang sau");
        example1.showArray(arr3);

        //sort descending array
        IntStream.of(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        //sort ascending array
        IntStream.of(arr)
                .boxed()
                .sorted()
                .forEach(System.out::println);
    }

    public static int maxArray(int[] array){
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max)
                max=array[i];
        }
        return max;
    }
    public static int secondMaxArray(int[] array){
        int max=array[0];
        int secondMax=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                secondMax=max;
                max=array[i];
            }
        }
        return secondMax;
    }
    public static int minArray(int[] array){
        int min=array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min)
                min=array[i];
        }
        return min;
    }
}
