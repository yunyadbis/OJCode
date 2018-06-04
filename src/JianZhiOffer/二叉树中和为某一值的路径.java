package JianZhiOffer;
import java.util.ArrayList;
public class 二叉树中和为某一值的路径 {
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> sub = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if( root==null)
            return res;
        sub.add(new Integer(root.val));
        target -= root.val;
        // 递归结束的条件
        if( root.left==null && root.right==null && target==0 ){
            res.add(new ArrayList<Integer>(sub));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 因为递归到子树会重新加一遍当前节点，所以要把它从当前数组中删除
        sub.remove(sub.size()-1);
        return res;
    }
    // 参考大佬的代码，深深地佩服！
}
