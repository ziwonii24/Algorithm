#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int n, m;
int p[501][501];
int g[501][501];
queue<pair<int, int>> q;
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

void bfs(int x, int y, int cnt) {
	q.push(make_pair(x, y));
	g[x][y] = cnt;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (p[nx][ny] == 1 && g[nx][ny] == 0) {
					g[nx][ny] = cnt;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			scanf("%d", &p[i][j]);

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (p[i][j] == 1 && g[i][j] == 0) {
				bfs(i, j, ++cnt);
			}
		}
	}

	printf("%d\n", cnt);
	if (cnt == 0) {
		printf("0\n");
		return 0;
	}

	int ans[500 * 500 / 2 + 1];
	for (int i = 0; i <= cnt; i++)
		ans[i] = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			ans[g[i][j]]++;
		}
	}

	sort(ans + 1, ans + cnt + 1);

	printf("%d\n", ans[cnt]);

	return 0;
}
