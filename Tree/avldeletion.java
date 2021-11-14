import java.util.*;

class node {
	int value;
	node right, left;
	int height = 1;

	node(int value) {
		this.value = value;
		right = null;
		left = null;
	}
}

public class avltreedeletion {
	static node root = null;
	static Scanner sc;

	static int height(node temp) {
		if (temp == null)
			return 0;
		return temp.height;
	}

	static int max(int a, int b) {
		return (a < b) ? b : a;
	}

	static node leftrotate(node temp) {
		node x = temp.right;
		node y = x.left;
		temp.right = y;
		x.left = temp;
		temp.height = max(height(temp.right), height(temp.left)) + 1;
		x.height = max(height(x.right), height(x.left)) + 1;
		return x;
	}

	static node rightrotate(node temp) {
		node x = temp.left;
		node y = x.right;
		temp.left = y;
		x.right = temp;
		temp.height = max(height(temp.right), height(temp.left)) + 1;
		x.height = max(height(x.right), height(x.left)) + 1;
		return x;
	}

	static int balancefactor(node temp) {
		if (temp == null)
			return 0;
		else
			return (height(temp.left) - height(temp.right));
	}

	static void print(node temp) {
		System.out.print(temp.value + " ");
		if (temp.left != null)
			print(temp.left);
		if (temp.right != null)
			print(temp.right);
	}

	static node insert(node temp, int value) {
		if (temp == null)
			return new node(value);
		if (temp.value < value)
			temp.right = insert(temp.right, value);
		else if (temp.value > value)
			temp.left = insert(temp.left, value);
		else
			return temp;
		temp.height = max(height(temp.left), height(temp.right)) + 1;
		int getbalance = balancefactor(temp);
		if (getbalance > 1 && temp.left.value > value)
			return rightrotate(temp);
		if (getbalance < -1 && temp.right.value < value)
			return leftrotate(temp);
		if (getbalance > 1 && temp.left.value < value) {
			temp.left = leftrotate(temp.left);
			return rightrotate(temp);
		}
		if (getbalance < -1 && temp.right.value > value) {
			temp.right = rightrotate(temp.right);
			return leftrotate(temp);
		}
		return temp;
	}

	static node min(node temp) {
		while (temp.left != null)
			temp = temp.left;
		return temp;
	}

	static node delete(node root, int value) {
		if (root == null)
			return root;
		if (root.value < value)
			root.right = delete(root.right, value);
		else if (root.value > value)
			root.left = delete(root.left, value);
		else {
			node temp = null;
			if (root.left == null || root.right == null) {
				if (root.left == null) {
					temp = root.right;
				} else
					temp = root.left;
				if (temp == null)
					root = null;
				else
					root = temp;
			} else {
				node min = min(root.right);
				root.value = min.value;
				root.right = delete(root.right, min.value);
			}
		}
		if (root == null)
			return root;
		root.height = max(height(root.right), height(root.left)) + 1;
		int balance = balancefactor(root);
		if (balance > 1 && balancefactor(root.left) >= 0)
			return rightrotate(root);
		if (balance > 1 && balancefactor(root.left) < 0) {
			root.left = leftrotate(root.left);
			return rightrotate(root);
		}
		if (balance < -1 && balancefactor(root.right) <= 0)
			return leftrotate(root);
		if (balance < -1 && balancefactor(root.right) > 0) {
			root.right = rightrotate(root.right);
			return leftrotate(root);
		}
		return root;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			root = insert(root, sc.nextInt());
		}
		print(root);
		System.out.println();
		n = sc.nextInt();
		while (n-- > 0) {
			int val = sc.nextInt();
			root = delete(root, val);
			print(root);
			System.out.println();
		}
	}
}
