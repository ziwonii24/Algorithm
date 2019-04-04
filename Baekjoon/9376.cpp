#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 100;
int n, m;
char arr[MAX + 2][MAX + 2];
int vis[MAX + 2][MAX + 2][3];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
deque<pair<int, int>> dq;

void print_arr() {
	cout << '\n';
	for (int i = 0; i <= n + 1; i++) {
		for (int j = 0; j <= m + 1; j++)
			cout << arr[i][j] << ' ';	
		cout << '\n';
	}
	cout << '\n';
}

void print_vis() {
	cout << '\n';
	for (int k = 0; k < 3; k++) {
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= m + 1; j++) {
				if (vis[i][j][k] == -1) cout << "- ";
				else cout << vis[i][j][k] << ' ';
			}
			cout << '\n';
		}
		cout << '\n';
	}
}

void init_arr() {
	for (int i = 0; i <= n + 1; i++) {
		arr[i][0] = '.';
		arr[i][m + 1] = '.';
	}
	for (int j = 0; j <= m; j++) {
		arr[0][j] = '.';
		arr[n + 1][j] = '.';
	}
	for (int k = 0; k < 3; k++)
		for (int i = 0; i <= n + 1; i++)
			for (int j = 0; j <= m + 1; j++)
				vis[i][j][k] = -1;
	
}

void bfs() {
	dq.push_back({ 0,0 });	//죄수1, 죄수2, 상근이
	for (int k = 0; k < 3; k++) {
		int sx = dq.back().first;
		int sy = dq.back().second;
		dq.pop_back();

		deque<pair<int, int>> q;
		q.push_back({ sx, sy });
		vis[sx][sy][k] = 0;

		while (!q.empty()) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop_front();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx <= n + 1 && ny >= 0 && ny <= m + 1) {
					if (vis[nx][ny][k] == -1 && arr[nx][ny] == '.') {
						vis[nx][ny][k] = vis[x][y][k];
						q.push_front({ nx, ny });
					}
					else if (vis[nx][ny][k] == -1 && arr[nx][ny] == '#') {
						vis[nx][ny][k] = vis[x][y][k] + 1;
						q.push_back({ nx, ny });
					}
				}
			}
		}
	}
}

int main() {
	init();
	int tc;
	cin >> tc;
	while (tc--) {
		cin >> n >> m;
		init_arr();
		for (int i = 1; i <= n; i++) {
			string str;
			cin >> str;
			for (int j = 1; j <= m; j++) {
				arr[i][j] = str[j-1];
				if (arr[i][j] == '$') {
					arr[i][j] = '.';
					dq.push_back({ i, j });
				}
			}
		}
		bfs();
		//print_vis();

		int ans = 987654321;
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= m + 1; j++) {
				if (arr[i][j] == '*') continue;
				int sum = vis[i][j][0] + vis[i][j][1] + vis[i][j][2];
				if (arr[i][j] == '#') sum -= 2;
				ans = min(ans, sum);
			}
		}

		cout << ans << '\n';
	}

	return 0;
}
