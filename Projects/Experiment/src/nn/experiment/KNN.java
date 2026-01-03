package nn.experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class KNN {

    static int dataLen = 20;
    static int k = 3;

    static record Data(int id, float height, int age, float weight){}

    public static int[] getDataHeight(File file) throws FileNotFoundException {
        ArrayList<Integer> al = new ArrayList<>(dataLen);
        try (
                Scanner inp = new Scanner(file);) {
            inp.nextLine();
            while (inp.hasNextLine()) {
                String str[] = inp.nextLine().trim().split(",");
                int weight = Integer.parseInt(str[1]);
                al.add(weight);
            }
        }
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    public static int[] getDataAge(File file) throws FileNotFoundException {
        ArrayList<Integer> al = new ArrayList<>(dataLen);
        try (
                Scanner inp = new Scanner(file);) {
            inp.nextLine();
            while (inp.hasNextLine()) {
                String str[] = inp.nextLine().trim().split(",");
                int age = Integer.parseInt(str[2]);
                al.add(age);
            }
        }
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    public static int[] getDataWeight(File file) throws FileNotFoundException {
        ArrayList<Integer> al = new ArrayList<>(dataLen);
        try (
                Scanner inp = new Scanner(file);) {
            inp.nextLine();
            while (inp.hasNextLine()) {
                String str[] = inp.nextLine().trim().split(",");
                int weight = Integer.parseInt(str[3]);
                al.add(weight);
            }
        }
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    public static float getEuchideanDistance(double x1, double y1, double x2, double y2) {
        return (float) Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        // System.out.println(Arrays.toString(getDataAge(new File("data.csv"))));
        // System.out.println(Arrays.toString(getDataWeight(new File("data.csv"))));

        try (
            Scanner inp = new Scanner(System.in);) {
            float minValue[] = new float[k];
            ArrayList<Float> al = new ArrayList<>();
            int height[] = getDataHeight(new File("data.csv"));
            int age[] = getDataAge(new File("data.csv"));
            int weight[] = getDataWeight(new File("data.csv"));
            // Arrays.sort(height);
            // Arrays.sort(age);
            // Arrays.sort(weight);
            float x1, y1;
            System.out.println("Enter value of Height: ");
            x1 = inp.nextFloat();
            System.out.println("Enter value of Age: ");
            y1 = inp.nextFloat();
            for (int i = 0; i < 20; i++) {
                al.add(getEuchideanDistance(x1, y1, height[i], age[i]));
            }

            // System.out.println(al);
            int minIndex[] = new int[k];
            for(int i = 0 ; i < k ; i++)
            {
                float min = 999;
                int minIdx = 0;
                for(int j = 0 ; j < al.size() ; j++)
                {
                    if(al.get(j) < min)
                    {
                        min = al.get(j);
                        minIdx = j;
                        minIndex[i] = j;
                    }
                    minValue[i] = min;
                    al.set(minIdx, (float) 999);
                }
            }
            // System.out.println(Arrays.toString(minValue));
            // System.out.println(al);
            float sum = 0;
            for (int i = 0; i < minIndex.length ; i++) {
                sum = weight[minIndex[i]] + sum;
            }
            float mean = sum / k;
            // System.out.println(Arrays.toString(arr));
            System.out.println("Predicted Weight = " + mean);
        }
    }
}
