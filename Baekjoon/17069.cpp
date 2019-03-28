#include <iostream>
#include <algorithm>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

typedef long long ll;
const int MAX = 32;
int n, arr[MAX + 1][MAX + 1];
ll ans, dp[MAX + 1][MAX + 1][3];

int dx[3] = { 0,1,1 };
int dy[3] = { 1,0,1 };

ll dfs(int x, int y, int dir) {
	if (dp[x][y][dir] != -1) return dp[x][y][dir];
	if (x == n - 1 && y == n - 1) return 1;

	dp[x][y][dir] = 0;
	if (dir == 0 || dir == 1) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (arr[nx][ny] == 0)
				dp[x][y][dir] = dp[x][y][dir] + dfs(nx, ny, dir);
		}

		nx = x + dx[2];
		ny = y + dy[2];

		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (arr[nx][ny] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0)
				dp[x][y][dir] = dp[x][y][dir] + dfs(nx, ny, 2);
		}
	}
	else if (dir == 2) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (arr[nx][ny] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0)
				dp[x][y][dir] = dp[x][y][dir] + dfs(nx, ny, 2);
		}

		for (int k = 0; k < 2; k++) {
			nx = x + dx[k];
			ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (arr[nx][ny] == 0)
					dp[x][y][dir] = dp[x][y][dir] + dfs(nx, ny, k);
			}
		}
	}

	return dp[x][y][dir];
}

int main() {
	init();
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			for (int k = 0; k < 3; k++)
				dp[i][j][k] = -1;

	ans = dfs(0, 1, 0);
	cout << ans;

	return 0;
}
