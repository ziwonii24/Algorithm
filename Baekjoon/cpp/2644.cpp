#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

typedef long long ll;
const int MAX = 100;
int n, m, x, y, dist[MAX+1];
vector<int> v[MAX + 1];

void bfs() {
	queue<int> q;
	q.push(x);
	dist[x] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i];

			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				q.push(next);
			}
		}
	}
}

int main() {
	init();
	cin >> n >> x >> y >> m;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 0; i <= MAX; i++)
		dist[i] = -1;

	bfs();
	cout << dist[y];

	return 0;
}
