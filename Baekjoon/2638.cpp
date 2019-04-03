#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 100;
int n, m, arr[MAX + 1][MAX + 1], vis[MAX + 1][MAX + 1];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void melting() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j]==1 && vis[i][j] >= 2)
				arr[i][j] = 0;
		}
	}
}

int remain_cheeze() {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 1)
				cnt++;
		}
	}
	return cnt;
}

void init_vis() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			vis[i][j] = 0;
}

void bfs() {
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	vis[0][0] = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == 0 && vis[nx][ny] == 0) {
					vis[nx][ny] = 1;
					q.push({ nx, ny });
				}
				else if (arr[nx][ny] == 1) {
					vis[nx][ny] += 1;
				}
			}
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];

	int ans = 0;
	while (1) {
		init_vis();

		if (remain_cheeze() == 0) break;
		else ans++;

		bfs();
		melting();
	}

	cout << ans;

	return 0;
}
