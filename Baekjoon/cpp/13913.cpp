#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 100000 + 1;
int n, k, ans;
bool vis[MAX];
int parent[MAX];
vector<int> path;

int bfs() {
	queue<pair<int, int>> q;
	q.push({ n, 0 });
	vis[n] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int sec = q.front().second;
		q.pop();
		
		if (x == k) {
			int idx = x;
			while (idx != n) {
				path.push_back(idx);
				idx = parent[idx];
			}
			path.push_back(n);
			return sec;
		}

		if (x - 1 >= 0 && !vis[x - 1]) {
			q.push({ x - 1, sec + 1 });
			vis[x - 1] = true;
			parent[x - 1] = x;
		}
		if (x + 1 < MAX && !vis[x + 1]) {
			q.push({ x + 1, sec + 1 });
			vis[x + 1] = true;
			parent[x + 1] = x;
		}
		if (2 * x < MAX && !vis[2 * x]) {
			q.push({ 2 * x, sec + 1 });
			vis[2 * x] = true;
			parent[2 * x] = x;
		}
	}
}

int main() {
	init();
	cin >> n >> k;
	ans = bfs();
	cout << ans << '\n';
	for (int i = path.size() - 1; i >= 0; i--)
		cout << path[i] << ' ';

	return 0;
}
