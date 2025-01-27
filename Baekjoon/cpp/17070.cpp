#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 16;
int n, arr[MAX + 1][MAX + 1], ans;
queue<pair<pair<int, int>, int>> q;
int dx[3] = { 0,1,1 };
int dy[3] = { 1,0,1 };

void bfs() {
	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int dir = q.front().second;
		q.pop();

		if (x == n - 1 && y == n - 1) {
			ans++;
			continue;
		}

		if (dir == 0 || dir == 1) {			//가로 또는 세로
			//그대로 이동
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (arr[nx][ny] == 0)
					q.push({ {nx, ny}, dir });
			}

			//대각선 이동
			nx = x + dx[2];
			ny = y + dy[2];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (arr[nx][ny] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0)
					q.push({ {nx, ny}, 2 });
			}
		}
		else if (dir == 2) {	//대각선
			//그대로 이동
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (arr[nx][ny] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0)
					q.push({ {nx, ny}, 2 });
			}

			for (int k = 0; k < 2; k++) {	//가로랑 세로 이동
				nx = x + dx[k];
				ny = y + dy[k];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (arr[nx][ny] == 0)
						q.push({ {nx, ny}, k });
				}
			}
		}
	}
}

int main() {
	init();
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

	q.push({ {0,1},0 });
	bfs();
	cout << ans;

	return 0;
}
