import java.util.*;

public class Main {
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int num = scanner.nextInt();
       ArrayList<unit> list = new ArrayList<>();
       for (int i = 1; i <= num; i++){
           unit u = new unit(i);
           u.setStart(scanner.nextInt());
           u.setEnd(scanner.nextInt());
           list.add(u);
       }
       Collections.sort(list, new SortByStart());
       int head = 0;
       int mark = -1;
       int listIndex = 0;
       for (unit u:list) {
           if (head <= u.getStart()){
               head = u.getEnd();
           }else {
               if (mark == -1){
                   mark = listIndex;
               }else {
                   System.out.println(0);
                   return;
               }
           }
           listIndex++;
       }
       if (mark == -1){
           System.out.println(num);
           for (int i = 1; i < num; i++){
               System.out.print(i + " ");
           }
           System.out.println(num);
       }else {
           if (mark == num - 1){
               int indexA = list.get(mark).getIndex();
               int indexB = list.get(mark - 1).getIndex();
               System.out.println(2);
               if (indexA < indexB){
                   System.out.print(indexA + " ");
                   System.out.println(indexB);
               }else {
                   System.out.print(indexB + " ");
                   System.out.println(indexA);
               }

           }else {
               unit preU = list.get(mark - 1);
               unit afterU = list.get(mark + 1);
               if (afterU.getStart() < list.get(mark).getEnd()){
                   System.out.println(1);
                   System.out.println(list.get(mark).getIndex());
               }else {
                   int indexA = list.get(mark).getIndex();
                   int indexB = list.get(mark - 1).getIndex();
                   System.out.println(2);
                   if (indexA < indexB){
                       System.out.print(indexA + " ");
                       System.out.println(indexB);
                   }else {
                       System.out.print(indexB + " ");
                       System.out.println(indexA);
                   }
               }
           }

       }

   }
}
class unit{
    public int index;
    public int start;
    public int end;
    public unit(int index){
        this.index = index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
class SortByStart implements Comparator {

    public int compare(Object o1, Object o2) {

        unit u1 = (unit) o1;   unit u2 = (unit) o2;
        if (u1.getStart() > u2.getStart()){
            return 1;
        }
        else if (u1.getStart() < u2.getStart()){
            return -1;
        }
        else {
            if (u1.getEnd() > u2.getEnd()){
                return 1;
            }else if (u1.getEnd() < u2.getEnd()){
                return -1;
            }else {
                return 0;
            }
        }
    }
}