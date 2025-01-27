#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

const int max_len = 10;
int n, m;
int s[max_len][max_len];	// 기존 연구소 상황
int d[max_len][max_len];	// 벽 3개가 위치할 수 있는 경우
int v[max_len][max_len];	// 바이러스가 퍼졌을때의 상황
int ans = 0;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void copy_map(int(*a)[max_len], int(*b)[max_len]) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			a[i][j] = b[i][j];
		}
	}
}

void cnt_save() {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] == 0)
				cnt++;
		}
	}

	ans = max(ans, cnt);
}

void bfs() {
	queue<pair<int, int>> q;
	copy_map(v, d);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] == 2)
				q.push({ i, j });
		}
	}

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (v[nx][ny] == 0) {
					v[nx][ny] = 2;
					q.push({ nx, ny });
				}
			}
		}
	}

	cnt_save();
}

void dfs(int cnt) {	//벽 3개 세우기
	if (cnt == 3) {
		bfs();
		return;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (d[i][j] == 0) {
				d[i][j] = 1;
				dfs(cnt + 1);
				d[i][j] = 0;
			}
		}
	}
}

int main(){
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &s[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (s[i][j] == 0) {
				copy_map(d, s);
				d[i][j] = 1;
				dfs(1);
				d[i][j] = 1;
			}
		}
	}

	printf("%d", ans);
	return 0;
}
