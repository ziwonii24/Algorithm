#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int m, n, h;
int a[101][101][101];
int d[101][101][101];
int dx[6] = { 0,0,0,0,1,-1 };
int dy[6] = { 0,0,1,-1,0,0 };
int dz[6] = { 1,-1,0,0,0,0 };
queue<pair<pair<int, int>, int>> q;

void bfs() {
	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int z = q.front().second;
		q.pop();

		for (int k = 0; k < 6; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			int nz = z + dz[k];

			if (nx >= 0 && nx < h && ny >= 0 && ny < m && nz >= 0 && nz < n) {
				if (a[nx][ny][nz] == 0 && d[nx][ny][nz] == -1) {
					d[nx][ny][nz] = d[x][y][z] + 1;
					q.push({ {nx, ny}, nz });
				}
			}
		}
	}
}

int main() {
	scanf("%d %d %d", &n, &m, &h);
	bool zero_chk = false;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < n; k++) {
				scanf("%d", &a[i][j][k]);
				d[i][j][k] = -1;
				if (a[i][j][k] == 1) {
					q.push({ {i, j}, k });
					d[i][j][k] = 0;
				}
				if (a[i][j][k] == 0) zero_chk = true;;
			}
		}
	}

	if (!zero_chk) {
		printf("0");
		return 0;
	}

	bfs();

	int ans = 0;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < n; k++) {
				if (a[i][j][k]!=-1 && d[i][j][k] == -1) {
					printf("-1");
					return 0;
				}
				else ans = max(ans, d[i][j][k]);
			}
		}
	}

	printf("%d", ans);

	return 0;
}
