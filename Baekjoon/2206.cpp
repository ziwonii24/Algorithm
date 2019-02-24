#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

const int MAX = 1001;
int n, m;
int a[MAX][MAX];	
int d[MAX][MAX][2];	//1: 벽 부수기 가능, 0: 벽 이미 한번 부숨
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int bfs() {
	queue<pair<pair<int, int>, int>> q;
	q.push({ {1,1},1 });
	d[1][1][1] = 1;

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int wall = q.front().second;
		q.pop();

		if (x == n && y == m) 
			return d[x][y][wall];

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
				if (a[nx][ny] == 1 && wall) {	//벽이 있고 아직 부술 기회가 있으면
					d[nx][ny][wall - 1] = d[x][y][wall] + 1;
					q.push({ {nx, ny}, wall - 1 });	//부수고 이동
				}
				else if (a[nx][ny] == 0 && d[nx][ny][wall] == 0) {	//벽이 없고 아직 방문 안했으면
					d[nx][ny][wall] = d[x][y][wall] + 1;
					q.push({ {nx, ny}, wall });	//그냥 이동
				}
			}
		}
	}

	return -1;
}

int main() {
	scanf("%d %d", &n, &m);	
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			scanf("%1d", &a[i][j]);

	printf("%d", bfs());
	return 0;
}
