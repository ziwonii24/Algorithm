#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 1000;
int n, m, w;
int arr[MAX + 1][MAX + 1], dist[MAX+1][MAX+1][11];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void bfs() {
	queue<pair<pair<int, int>, int>> q;
	q.push({ { 0,0 },0 });
	dist[0][0][0] = 1;

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int wall = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == 0 && dist[nx][ny][wall] == 0) {
					dist[nx][ny][wall] = dist[x][y][wall] + 1;
					q.push({ {nx, ny}, wall });
				}
				else if (arr[nx][ny] == 1 && dist[nx][ny][wall + 1] == 0 && wall + 1 <= w) {
					dist[nx][ny][wall + 1] = dist[x][y][wall] + 1;
					q.push({ {nx, ny}, wall + 1 });
				}
			}
		}

	}
}

int main() {
	init();
	cin >> n >> m >> w;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++)
			arr[i][j] = str[j] - '0';
	}

	bfs();

	int ans = 987654321;
	for (int i = 0; i <= w; i++) {
		//cout << dist[n - 1][m - 1][i] << '\n';
		if (dist[n - 1][m - 1][i] != 0)
			ans = min(ans, dist[n - 1][m - 1][i]);
	}
	if (ans == 987654321) cout << -1;
	else cout << ans;

	return 0;
}
