/**
 * Package: PACKAGE_NAME
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/6/23 15:30
 */
public class GetPathInMatrix {
    public static void main(String[] args) {
        //a b c e s f c s a d e e
        char [] array = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char [] target = {'b','c','c','e','d'};
        System.out.println(hasPath(array,3,4,target));
    }
    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchFromHere(matrix,rows,cols,i,j,0,str,visited))
                 return true;
            }
        }
//        System.out.println(Arrays.toString(visited));
         return false;
    }
    private static boolean searchFromHere(char[] matrix,int rows,int cols,int r,int c,int index,char[] str,boolean[] visited){
        // 数组下标越界 或 字母不匹配 或 visited为false
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
             return false;
        //递归结束控制语句
        if (index == str.length - 1) return true;

        visited[r * cols + c] = true;
        if (searchFromHere(matrix,rows,cols,r - 1,c,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r,c -1,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r + 1,c,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r,c + 1,index + 1,str,visited))
        return true;
         visited[r * cols + c] = false;
        return false;
     }
}
