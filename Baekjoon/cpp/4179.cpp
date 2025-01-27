#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 1000;
int n, m;
char arr[MAX + 1][MAX + 1];
int dist[MAX + 1][MAX + 1], fire_dist[MAX + 1][MAX + 1];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue<pair<int, int>> jq;
queue<pair<int, int>> fq;

void print_dist() {
	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (fire_dist[i][j] == -1) cout << "- ";
			else cout << fire_dist[i][j] << ' ';
		}
		cout << '\n';
	}
	cout << '\n';

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (dist[i][j] == -1) cout << "- ";
			else cout << dist[i][j] << ' ';
		}
		cout << '\n';
	}
	cout << '\n';
}

void init_dist() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			dist[i][j] = -1;
			fire_dist[i][j] = -1;
		}
	}
}

void bfs_fire() {
	while (!fq.empty()) {
		int x = fq.front().first;
		int y = fq.front().second;
		fq.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == '.' || arr[nx][ny] == 'J') {
					if (fire_dist[nx][ny] == -1 || fire_dist[x][y] + 1 < fire_dist[nx][ny]) {
						fire_dist[nx][ny] = fire_dist[x][y] + 1;
						fq.push({ nx, ny });
					}
				}
			}
		}
	}
}

void bfs_me() {
	int x = jq.front().first;
	int y = jq.front().second;
	dist[x][y] = 0;

	while (!jq.empty()) {
		x = jq.front().first;
		y = jq.front().second;
		jq.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (dist[nx][ny] == -1 && arr[nx][ny] == '.') {
					if (fire_dist[nx][ny] == -1 || dist[x][y] + 1 < fire_dist[nx][ny]) {
						dist[nx][ny] = dist[x][y] + 1;
						jq.push({ nx, ny });
					}
				}
			}
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	init_dist();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'J') jq.push({ i, j });
			else if (arr[i][j] == 'F') {
				fq.push({ i, j });
				fire_dist[i][j] = 0;
			}
		}
	}

	bfs_fire();
	bfs_me();

	//print_dist();

	int ans = 987654321;
	for (int k = 0; k < n; k++) {
		if (dist[k][0] != -1) ans = min(ans, dist[k][0]);
		if (dist[k][m - 1] != -1) ans = min(ans, dist[k][m - 1]);
	}
	for (int k = 0; k < m; k++) {
		if (dist[0][k] != -1) ans = min(ans, dist[0][k]);
		if (dist[n-1][k] != -1) ans = min(ans, dist[n-1][k]);
	}
	if (ans == 987654321) cout << "IMPOSSIBLE";
	else cout << ans + 1;

	return 0;
}
