package CodeChef;

import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
 
/**
* Built using CHelper plug-in
* Actual solution is at the top
*/
public class Main {
public static void main(String[] args) {
InputStream inputStream = System.in;
OutputStream outputStream = System.out;
InputReader in = new InputReader(inputStream);
PrintWriter out = new PrintWriter(outputStream);
Dragonstone solver = new Dragonstone();
int testCount = Integer.parseInt(in.next());
for (int i = 1; i <= testCount; i++)
solver.solve(i, in, out);
out.close();
}
}
 
class Dragonstone {
private Point[] p;
private int n;
private int[] depth;
private int[][] parent;
private int logN;
private int[][] maxLength;
 
public void solve(int testNumber, InputReader in, PrintWriter out) {
n = in.nextInt();
p = new Point[n];
for (int i = 0; i < n; ++i) {
Point pp = new Point();
pp.x = in.nextInt();
pp.y = in.nextInt();
pp.number = i;
p[i] = pp;
}
createMST(createEdges());
prepareLCA();
int numQueries = in.nextInt();
for (int q = 0; q < numQueries; ++q) {
int u = in.nextInt() - 1;
int v = in.nextInt() - 1;
out.println(calc(u, v));
}
}
 
private int calc(int u, int v) {
if (depth[u] < depth[v]) {
int t = u;
u = v;
v = t;
}
int answer = Integer.MIN_VALUE;
for (int i = logN; i >= 0; --i)
if (depth[u] - (1 << i) >= depth[v]) {
answer = Math.max(answer, maxLength[u][i]);
u = parent[u][i];
}
if (u == v) return answer;
for (int i = logN; i >= 0; --i)
if (parent[u][i] != parent[v][i]) {
answer = Math.max(answer, Math.max(maxLength[u][i], maxLength[v][i]));
u = parent[u][i];
v = parent[v][i];
}
answer = Math.max(answer, Math.max(maxLength[u][0], maxLength[v][0]));
return answer;
}
 
private void prepareLCA() {
for (int j = 1; 1 << j < n; ++j)
for (int i = 0; i < n; ++i)
if (parent[i][j - 1] != -1) {
parent[i][j] = parent[parent[i][j - 1]][j - 1];
maxLength[i][j] = Math.max(maxLength[i][j - 1], maxLength[parent[i][j - 1]][j - 1]);
}
}
 
private void createMST(Edge[] edges) {
Arrays.sort(edges, new Comparator<Edge>() {
@Override
public int compare(Edge o1, Edge o2) {
return o1.length - o2.length;
}
});
DisjointSet set = new DisjointSet(n);
List<Edge>[] adj = new List[n];
for (int i = 0; i < n; ++i) {
adj[i] = new ArrayList<Edge>(1);
}
for (Edge edge : edges) {
int u = edge.x;
int v = edge.y;
int length = edge.length;
if (set.joinSet(u, v)) {
adj[u].add(new Edge(u, v, length));
adj[v].add(new Edge(v, u, length));
}
}
assert set.countSet() == 1;
int[] last = new int[n];
int[] stack = new int[n];
depth = new int[n];
logN = 0;
while (1 << (logN + 1) < n) ++logN;
parent = new int[n][logN + 1];
maxLength = new int[n][logN + 1];
for (int[] ints : parent) Arrays.fill(ints, -1);
for (int[] ints : maxLength) Arrays.fill(ints, Integer.MIN_VALUE);
int stackSize = 1;
while (stackSize > 0) {
int at = stack[stackSize - 1];
if (last[at] == adj[at].size()) {
--stackSize;
} else {
int child = adj[at].get(last[at]).y;
int length = adj[at].get(last[at]).length;
++last[at];
if (parent[at][0] == child) continue;
parent[child][0] = at;
maxLength[child][0] = length;
depth[child] = depth[at] + 1;
stack[stackSize++] = child;
}
}
}
 
private Edge[] createEdges() {
Edge[] edges = new Edge[8 * n];
int m = 0;
for (int a = 0; a < 2; ++a) {
for (int b = 0; b < 2; ++b) {
for (int c = 0; c < 2; ++c) {
Arrays.sort(p, new Comparator<Point>() {
@Override
public int compare(Point o1, Point o2) {
if (o1.y == o2.y) return o1.x - o2.x;
return o2.y - o1.y;
}
});
int[] keys = new int[n];
for (int i = 0; i < n; ++i) keys[i] = p[i].x + p[i].y;
keys = ArraysUtils.sortAndUnique(keys);
BinaryIndexedTree tree = new BinaryIndexedTree(keys.length);
for (int i = 0; i < n; ++i) {
Point pp = p[i];
int where = Arrays.binarySearch(keys, pp.x + pp.y);
Point near = tree.get(where);
if (near != null) edges[m++] = new Edge(pp.number, near.number, pp.distance(near));
tree.update(where, pp);
}
for (int i = 0; i < n; ++i) p[i].reflectDiagonal();
}
for (int i = 0; i < n; ++i) p[i].reflectOy();
}
for (int i = 0; i < n; ++i) p[i].reflectOx();
}
return Arrays.copyOf(edges, m);
}
 
class Point {
int x;
int y;
int number;
 
public void reflectDiagonal() {
int t = x;
x = y;
y = t;
}
 
public void reflectOy() {
y = -y;
}
 
public void reflectOx() {
x = -x;
}
 
public int distance(Point other) {
return Math.abs(x - other.x) + Math.abs(y - other.y);
}
}
 
class BinaryIndexedTree {
final Comparator<Point> COMPARATOR = new Comparator<Point>() {
@Override
public int compare(Point o1, Point o2) {
if (o1 == null) return +1;
if (o2 == null) return -1;
return (-o1.x + o1.y) - (-o2.x + o2.y);
}
};
Point[] data;
 
public BinaryIndexedTree(int n) {
data = new Point[n];
}
 
public Point get(int at) {
Point result = null;
while (at >= 0) {
if (COMPARATOR.compare(result, data[at]) > 0)
result = data[at];
at -= ~at & (at + 1);
}
return result;
}
 
public void update(int at, Point by) {
while (at < data.length) {
if (COMPARATOR.compare(data[at], by) > 0)
data[at] = by;
at |= at + 1;
}
}
}
 
class Edge {
int x;
int y;
int length;
 
public Edge(int x, int y, int length) {
this.x = x;
this.y = y;
this.length = length;
}
}
}
 
class InputReader {
private BufferedReader reader;
private StringTokenizer tokenizer;
 
public InputReader(InputStream stream) {
reader = new BufferedReader(new InputStreamReader(stream), 32768);
tokenizer = null;
}
 
public String next() {
while (tokenizer == null || !tokenizer.hasMoreTokens())
try {
tokenizer = new StringTokenizer(reader.readLine());
} catch (IOException e) {
throw new RuntimeException(e);
}
return tokenizer.nextToken();
}
 
public int nextInt() {
return Integer.parseInt(next());
}
 
}
 
class DisjointSet {
private final int[] label;
private int numSets;
private Listener listener;
 
public DisjointSet(int n, Listener listener) {
label = new int[n];
Arrays.fill(label, -1);
numSets = n;
this.listener = listener;
}
 
public DisjointSet(int n) {
this(n, null);
}
 
public int getSet(int at) {
if (label[at] < 0) return at;
return label[at] = getSet(label[at]);
}
 
public boolean sameSet(int u, int v) {
return getSet(u) == getSet(v);
}
 
public int countSet() {
return numSets;
}
 
public boolean joinSet(int u, int v) {
if (sameSet(u, v)) return false;
u = getSet(u);
v = getSet(v);
if (label[u] < label[v]) {
int tmp = u;
u = v;
v = tmp;
}
label[v] += label[u];
label[u] = v;
--numSets;
if (listener != null) listener.joined(u, v);
return true;
}
 
public static interface Listener {
public void joined(int joinedRoot, int root);
}
}
 
class ArraysUtils {
public static int[] sortAndUnique(int[] a) {
Integer[] b = new Integer[a.length];
for (int i = 0; i < a.length; ++i)
b[i] = a[i];
Arrays.sort(b);
int n = 0;
for (int i = 0; i < a.length; ) {
int j = i;
while (j < a.length && b[i].equals(b[j])) ++j;
a[n++] = b[i];
i = j;
}
return Arrays.copyOf(a, n);
}
}