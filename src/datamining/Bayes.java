package datamining;

import javax.transaction.xa.Xid;

/**
 * Package: datamining
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/6/25 20:44
 */
public class Bayes {
    //数据数组
    static int [][] data = {
                     {0,1,3,2,2,2},
                     {0,1,3,2,1,2},
                     {0,2,3,2,2,1},
                     {0,3,2,2,2,1},
                     {0,3,1,1,2,1},
                     {0,3,1,1,1,2},
                     {0,2,1,1,1,1},
                     {0,1,2,2,2,2},
                     {0,1,1,1,2,1},
                     {0,3,2,1,2,1},
                     {0,1,2,1,1,1},
                     {0,2,2,2,1,1},
                     {0,2,3,1,2,1},
                     {0,3,2,2,1,2},};

    /**
     * 互信息计算
     * @param xIndex
     * @param xRange
     * @param yIndex
     * @param yRange
     * @param zIndex
     * @param zRange
     * @return outCome
     */
    public static double bothInfo(int xIndex, int xRange, int yIndex,int yRange, int zIndex, int zRange){
        double outCome = 0;
        double prob = 0;
        double value= 0;
        double valOne = 0;
        double valTwo = 0;
        for (int i = 1; i <= xRange; i++){
            for (int j = 1; j <= yRange; j++){
                for (int k = 1; k <= zRange; k++) {
                    prob = getProb_xyz(i,xIndex,j,yIndex,k,zIndex);
                    value = getProb_xyByz(i,xIndex,j,yIndex,k,zIndex);
                    valOne = getProb_aByb(i, xIndex, k, zIndex);
                    valTwo = getProb_aByb(j, yIndex, k, zIndex);
                    //非零判断
                    if (prob - 0 < 0.0000000001)continue;
                    if (value - 0 < 0.0000000001 )continue;
                    if (valOne - 0 < 0.0000000001)continue;
                    if (valTwo - 0 < 0.0000000001)continue;
                    //求和
                    outCome += calcute(prob,value,valOne,valTwo);
                    //System.out.println("======outCome:"+outCome);
                }
            }
        }

        System.out.println("最终："+outCome);
        return outCome;
    }

    /**
     * 计算求和的每个元素
     * @param prob
     * @param value
     * @param valOne
     * @param valTwo
     * @return
     */
    private static double calcute(double prob, double value, double valOne, double valTwo) {
        double upValue = value/(valOne * valTwo);
        double calValue = Math.log(upValue)/Math.log(2);
        //System.out.println("upValue:" + upValue + "  calValue:" + calValue);
        //System.out.println("calcute:"+prob * calValue);
        return prob * calValue ;
    }

    /**
     * 计算 p（xyz）
     * @param x
     * @param xIndex
     * @param y
     * @param yIndex
     * @param z
     * @param zIndex
     * @return
     */
    private static double getProb_xyz(int x, int xIndex, int y, int yIndex, int z, int zIndex){
        double countXYZ= 0;
        for (int i = 0; i < data.length; i++){
            if (data[i][zIndex] == z && data[i][xIndex] == x && data[i][yIndex] == y){
                countXYZ++;
            }
        }
        //System.out.println("countXYZ:" + countXYZ + "  data.length:" + data.length);
        //System.out.println("getProb_xyz:" + countXYZ/data.length);
        return countXYZ/data.length;
    }

    /**
     * 计算 p（x,y|z）
     * @param x
     * @param xIndex
     * @param y
     * @param yIndex
     * @param z
     * @param zIndex
     * @return
     */
    private static double getProb_xyByz(int x, int xIndex, int y, int yIndex, int z, int zIndex){
        double countZ = 0;
        double countXY_Z = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i][zIndex] == z){
                countZ++;
                if (data[i][xIndex] == x && data[i][yIndex] == y){
                    countXY_Z++;
                }
            }
        }
        //System.out.println("countXY_Z:" + countXY_Z + "  countZ:" + countZ);
        //System.out.println("getProb_xyByz:" + countXY_Z/countZ);
        return countXY_Z/countZ;
    }

    /**
     * 计算 p（x|y）
     * @param a
     * @param aIndex
     * @param b
     * @param bIndex
     * @return
     */
    private static double getProb_aByb(int a, int aIndex, int b, int bIndex) {
        double countB = 0;
        double countA_B = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i][bIndex] == b){
                countB++;
                if (data[i][aIndex] == a){
                    countA_B++;
                }
            }
        }
        //System.out.println("countA_B:" + countA_B + "  countB:" + countB);
        //System.out.println("getProb_aByb:"+countA_B/countB);
        return countA_B/countB;
    }

    /**
     * starting program
     *
     * @param args
     */
    public static void main(String[] args) {
        //index: =====  1:年龄(3)   2:收入(3)   3:学生(2)   4:信誉(2)   5:购买计算机(2)
        bothInfo(1,3,2,3,5,2);
        bothInfo(1,3,3,2,5,2);
        bothInfo(1,3,4,2,5,2);
        bothInfo(2,3,3,2,5,2);
        bothInfo(2,3,4,2,5,2);
        bothInfo(3,2,4,2,5,2);
    }
}
