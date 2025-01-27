#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 100000 + 1;
int n, k;
int vis[MAX];

int bfs() {
	queue<int> q;
	q.push(n);
	vis[n] = 0;
	
	while (!q.empty()) {
		int x = q.front();
		q.pop();

		if (x == k) return vis[x];

		if (x - 1 >= 0 && vis[x - 1] == -1) {
			q.push(x - 1);
			vis[x - 1] = vis[x] + 1;
		}
		if (x + 1 < MAX && vis[x + 1] == -1) {
			q.push(x + 1);
			vis[x + 1] = vis[x] + 1;
		}
		if (2 * x < MAX && vis[2 * x] == -1) {
			q.push(2 * x);
			vis[2 * x] = vis[x] + 1;
		}
	}
}

int main() {
	init();
	cin >> n >> k;
	for (int i = 0; i < MAX; i++)
		vis[i] = -1;
	cout << bfs();
	return 0;
}
