/*
	This is an implementation of the disjoint-set
	data structure. This data structure is also 
	known as the union-find data structure. 

	Every set is identified by a representative node. 
	Each node points to its parent node. Root points
	to itself. Each node has a height associated with it.
	Supported methods: 
	1. makeSet(): Creates n sets with one element each
	2. find(int x): Find representative of set containing x
	3. Union(int x, int y): Combine x's set with y's set

	Let n be the number of nodes. Nodes are labeled 0 through n-1 
	Time complexity: See below
	Space complexity: O(n)
*/
public class DisjointSets {
	private int[] parent;
	private int[] height;
	private int n; // number of nodes

	public DisjointSets(int n) {
		this.n = n;
		parent = new int[n];
		// Height values are equal to 0 initially
		height = new int[n];
	}

	// Create n different sets of one element each
	// Time complexity: O(n), where n is nb of nodes
	public void makeSet() {
		// Each node is in its own set initially
		for (int idx = 0; idx < n; idx++) {
			parent[idx] = idx;
		}
	}

	// Find the ultimate parent of node v, i.e.,
	// representative of v's set.
	// Time complexity: O(h), h is height of tree
	// rooted at the representative of v's set
	public int find(int v) {
		// If v is not representative then
		// v's parent is different from v
		if (parent[v] != v) {
			parent[v] = find(parent[v]);
		}
		return parent[v];
	}

	// Combine the v's set with u's set and
	// return boolean indicating if union occurred
	// Time complexity: O(1)
	public boolean union(int u, int v) {
		// Find representative for u's and v's sets
		int pu = find(u);
		int pv = find(v);
		// If same, then u and v are part of same set
		if (pu == pv)
			return false;
		// Combine two sets depending on heights of u and v
		if (height[pu] < height[pv]) {
			parent[pu] = pv;
		} else if (height[pv] < height[pu]) {
			parent[pv] = pu;
		} else {
			parent[pu] = pv;
			height[pv]++;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 5; // 5 nodes, with ids: 0, 1, 2, 3, 4
		DisjointSets ds = new DisjointSets(n);
		ds.makeSet(); // Create independent sets
		// Combine a number of sets together
		boolean combined = ds.union(0, 3);
		System.out.println(combined); // true
		combined = ds.union(4, 3);
		System.out.println(combined); // true
		combined = ds.union(0, 4);
		System.out.println(combined); // false (already combined)

		if (ds.find(0) == ds.find(3)) {
			System.out.println("3 and 0 are part of same set");
		} else {
			System.out.println("3 and 0 are part of different sets");
		}
	}
}
