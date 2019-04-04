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
deque<pair<int, int>> dq1;

void init_arr() {	//배열 초기화
	//arr배열 확장
	for (int i = 0; i <= n + 1; i++) {
		arr[i][0] = '.';
		arr[i][m + 1] = '.';
	}
	for (int j = 0; j <= m; j++) {
		arr[0][j] = '.';
		arr[n + 1][j] = '.';
	}
	//vis배열 초기화
	for (int k = 0; k < 3; k++)
		for (int i = 0; i <= n + 1; i++)
			for (int j = 0; j <= m + 1; j++)
				vis[i][j][k] = -1;
	
}

void bfs() {
	dq1.push_back({ 0,0 });	//dq1상태 : 죄수1, 죄수2, 상근이
	for (int k = 0; k < 3; k++) {
		int sx = dq1.back().first;
		int sy = dq1.back().second;
		dq1.pop_back();	//상근이, 죄수2, 죄수1 순으로 pop (k=0,1,2)

		deque<pair<int, int>> dq2;
		dq2.push_back({ sx, sy });
		vis[sx][sy][k] = 0;

		while (!dq2.empty()) {
			int x = dq2.front().first;
			int y = dq2.front().second;
			dq2.pop_front();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx <= n + 1 && ny >= 0 && ny <= m + 1) {
					if (vis[nx][ny][k] == -1 && arr[nx][ny] == '.') {
						vis[nx][ny][k] = vis[x][y][k];
						dq2.push_front({ nx, ny });
					}
					else if (vis[nx][ny][k] == -1 && arr[nx][ny] == '#') {
						vis[nx][ny][k] = vis[x][y][k] + 1;
						dq2.push_back({ nx, ny });
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
					dq1.push_back({ i, j });
				}
			}
		}

		bfs();

		int ans = 987654321;
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= m + 1; j++) {
				if (arr[i][j] == '*') continue;	//벽이면넘기기, 더할필요x
				int sum = vis[i][j][0] + vis[i][j][1] + vis[i][j][2];
				if (arr[i][j] == '#') sum -= 2;	//문이면 세번더했으므로 두번빼줌
				ans = min(ans, sum);
			}
		}

		cout << ans << '\n';
	}

	return 0;
}
