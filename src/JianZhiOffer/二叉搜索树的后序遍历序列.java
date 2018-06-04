package JianZhiOffer;
import java.util.ArrayList;
public class 二叉搜索树的后序遍历序列 {
	public static void main(String[] args){
		int[] a = {4,6,5,7};
		boolean res = VerifySquenceOfBST(a);
		System.out.println(res);
	}
	public static boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len==0)
            return false;
        if(len==1)
            return true;
        int root = sequence[len-1];
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int i = 0;
        while(i<len-1){
            if(sequence[i]>root)
                break;
            left.add(new Integer(sequence[i]));
            i ++;
        }
        while(i<len-1){
            if(sequence[i]<root) return false;
            right.add(new Integer(sequence[i]));
            i++;
        }
        boolean l = true;
        boolean r = true;
        if(left.size()!=0){
            Integer[] tmpInteger = new Integer[left.size()];
            int[] tmpInt = new int[left.size()];
            left.toArray(tmpInteger);
            for(int m=0; m<tmpInteger.length; m++){
                tmpInt[m] = tmpInteger[m];
            }
            l = VerifySquenceOfBST(tmpInt);
        }
            
        if(right.size()!=0){
            Integer[] tmpInteger = new Integer[right.size()];
            int[] tmpInt = new int[right.size()];
            left.toArray(tmpInteger);
            for(int m=0; m<tmpInteger.length; m++){
                tmpInt[m] = tmpInteger[m];
            }
            r = VerifySquenceOfBST(tmpInt);
        }
            
        return l&&r;
    }
}
