import java.io.*;
import java.util.*;

class SegmentTree {
    long[] tree;
    long[] arr;
    int n;

    public SegmentTree(long[] input) {
        this.n = input.length;
        this.arr = input;
        this.tree = new long[4 * n]; // 4N is a safe size for the segment tree
        build(1, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {  // Leaf node
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1]; // Combine results
        }
    }

    public void update(int index, long newValue) {
        update(1, 0, n - 1, index, newValue);
    }

    private void update(int node, int start, int end, int index, long newValue) {
        if (start == end) {
            tree[node] = newValue;
            arr[index] = newValue;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                update(2 * node, start, mid, index, newValue);
            } else {
                update(2 * node + 1, mid + 1, end, index, newValue);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public long query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    private long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, left, right);
        long rightSum = query(2 * node + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segTree = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            if (A == 1) { // Update operation
                segTree.update(B - 1, C); // Convert 1-based index to 0-based
            } else if (A == 2) { // Query operation
                sb.append(segTree.query(B - 1, (int) C - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }
}