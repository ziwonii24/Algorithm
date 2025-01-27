#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 100;
int n, m, dist[MAX + 1];
vector<int> v[MAX + 1];
int ans_idx, ans_sum = 987654321;

void bfs(int x) {
	queue<int> q;
	q.push(x);
	dist[x] = 0;
	
	while (!q.empty()) {
		x = q.front();
		q.pop();

		for (int i = 0; i < v[x].size(); i++) {
			int y = v[x][i];
			if (dist[y] == -1) {
				dist[y] = dist[x] + 1;
				q.push(y);
			}
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		for (int k = 1; k <= n; k++)
			dist[k] = -1;

		bfs(i);

		int sum = 0;
		for (int k = 1; k <= n; k++)
			sum += dist[k];

		if (sum < ans_sum) {
			ans_sum = sum;
			ans_idx = i;
		}
	}

	cout << ans_idx;

	return 0;
}
