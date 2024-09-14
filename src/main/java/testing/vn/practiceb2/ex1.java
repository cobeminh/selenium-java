package testing.vn.practiceb2;

public class ex1 {
    /*
    cho 1 mang int[] array=[1,0,0]
    viet 1 ctr cong mang array voi 1
    output array+1= [1,0,1]
    array=[9,9]
    array+1=[1,0,0]
    (ý là các phần tử trong mảng là 1 số tự nhiên, kiểu 99+1=100 ấy)
    convert từ mảng sang số tự nhiên>xong cộng(charAt(i))> xong convert lại
     */
    public static void main(String[] args) {
        int[] array = {9, 9};
        int[] array1 = {8, 9};
        ex1 example1 = new ex1();
        showArray(example1.addArray(array));
        showArray(example1.addArray(array1));
    }

    public int[] addArray(int[] array) {
        String tmp = "";
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
        }
        int stringToNumber = 0;
        stringToNumber = Integer.parseInt(tmp) + 1;
        String numberToString = String.valueOf(stringToNumber);
        //khai bao mảng có độ dài bằng độ dài của chuỗi sau khi +1
        int[] restarray = new int[numberToString.length()];
        for (int i = 0; i < numberToString.length(); i++) {
            restarray[i] = Integer.parseInt(String.valueOf(numberToString.charAt(i)));
        }
        return restarray;
    }

    public static void showArray(int[] arrray) {
        for (int i = 0; i < arrray.length; i++) {
            System.out.print(arrray[i] + " ");
        }
    }
}
