#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 100000 + 1;
int n, k;
bool vis[MAX];

int bfs() {
	queue<pair<int, int>> q;
	q.push({ n, 0 });
	vis[n] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int sec = q.front().second;
		q.pop();
		
		if (x == k) return sec;

		if (2 * x < MAX && !vis[2 * x]) {
			q.push({ 2 * x, sec });
			vis[2 * x] = true;
		}
		if (x - 1 >= 0 && !vis[x - 1]) {
			q.push({ x - 1, sec + 1 });
			vis[x - 1] = true;
		}
		if (x + 1 < MAX && !vis[x + 1]) {
			q.push({ x + 1, sec + 1 });
			vis[x + 1] = true;
		}
	}
}

int main() {
	init();
	cin >> n >> k;
	cout << bfs();
	return 0;
}
