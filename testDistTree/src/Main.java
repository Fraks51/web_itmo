
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 2, 6, 4};
        DistTree tree = new DistTree(a);
        assert (tree.findMin(0, 3) == 1);
        assert (tree.findMin(0, 7) == 1);
        assert (tree.findMin(5, 7) == 2);
        assert (tree.findMin(2, 3) == 3);
        int[] b = {4, 5 ,7};
        tree = new DistTree(b);
        assert (tree.findMin(0, 0) == 0);
        assert (tree.findMin(1, 2) == 5);
        System.out.print("OK");
    }
}
