import java.io.*;

public class Influenza_k {

    public static void main(String[] args) throws IOException {

        int k =Integer.parseInt(args[0]);
        String filePath = args[1];
        File file = new File(filePath);
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(file));

        int count = 0;      // to count einai gia na metrhsoume ola ta stoixeia pou tha exei o pinakas mas
        int i = 0;
        while ((line = br.readLine()) != null) {
            count++;       // auksanw to count kata 1 gia na metrhsw poses line yparxoun
        }
        br.close();

        BufferedReader br2 = new BufferedReader(new FileReader(file));
        City []city = new City[count];
        while ((line = br2.readLine()) != null){
            String []temp = line.split("\\s+");
            City t = new City(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            city[i] = t;
            i++;
        }
        boolean flag = true;
        for(i =0; i< city.length;i++){
            if(city[i].getID()<1 ||city[i].getID()>999 ){
                flag = false;
                System.out.println("The id is wrong");
            }
            if(city[i].getInfluenzaCases() ==-1){
                flag = false;
                System.out.println("The number of influenza cases you gave is bigger than the population");
            }
        }
        if(flag) {
            quicksort(city, 0, count - 1);

            if (k > count) {
                System.out.println("there are not enough cities");
            } else {
                System.out.println("The top " + k + " cities are : ");
                for (int index = 0; index < k; index++) {
                    System.out.println(city[index].getName());
                }

            }
        }



    }


    static void quicksort(City[] array ,int start ,int end){
        if (end <= start ) return;
        int pivot  = partition (array,start,end);
        quicksort(array,start,pivot-1);
        quicksort(array,pivot+1,end);
    }

    static int partition(City[] array,int start, int end){
        City pivot = array[end];
        int i = start - 1;
        int j = end;
        for(;;){

            while(less(array[++i],pivot));
            while (less(pivot,array[--j]))
                if(j==start) break;
            if(i >= j) break;
            exch(array,i,j);
        }
        exch(array,i,end);
        return i;
    }
    static void exch(City[] array,int i , int j){
        City temp = array[i];
        array[i]= array[j];
        array[j]= temp;
    }

    public static boolean less(City i, City j) {
        return i.compareTo(j)<0;
    }

}


