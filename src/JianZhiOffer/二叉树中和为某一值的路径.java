package JianZhiOffer;
import java.util.ArrayList;
public class �������к�Ϊĳһֵ��·�� {
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> sub = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if( root==null)
            return res;
        sub.add(new Integer(root.val));
        target -= root.val;
        // �ݹ����������
        if( root.left==null && root.right==null && target==0 ){
            res.add(new ArrayList<Integer>(sub));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // ��Ϊ�ݹ鵽���������¼�һ�鵱ǰ�ڵ㣬����Ҫ�����ӵ�ǰ������ɾ��
        sub.remove(sub.size()-1);
        return res;
    }
    // �ο����еĴ��룬����������
}
