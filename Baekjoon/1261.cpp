#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 100;
const int INF = MAX * MAX + 1;
int n, m, arr[MAX + 1][MAX + 1], bomb[MAX + 1][MAX + 1];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void bfs() {
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	bomb[0][0] = 0;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == 0 && bomb[x][y] < bomb[nx][ny]) {
					q.push({ nx, ny });
					bomb[nx][ny] = bomb[x][y];
				}
				else if (arr[nx][ny] == 1 && bomb[x][y] + 1 < bomb[nx][ny]) {
					q.push({ nx, ny });
					bomb[nx][ny] = bomb[x][y] + 1;
				}
			}
		}
	}
}

int main() {
	init();
	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++)
			arr[i][j] = str[j]-'0';		
	}	//(0,0)시작, (n-1, m-1)끝

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			bomb[i][j] = INF;

	bfs();

	cout << bomb[n - 1][m - 1];

	return 0;
}
