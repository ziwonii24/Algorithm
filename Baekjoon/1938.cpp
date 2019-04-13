#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 50 + 2;
int n;
char arr[MAX][MAX];
bool vis[MAX][MAX][2];
pair<int, int> BBB[3], EEE[3], B_center, E_center;
int B_shape, E_shape;
int dx[8] = { -1,-1,-1,0,0,1,1,1 };
int dy[8] = { -1,0,1,-1,1,-1,0,1 };

void print_vis() {
	cout << '\n';
	for (int k = 0; k < 2; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				cout << vis[i][j][k] << ' ';
			cout << '\n';
		}
		cout << '\n';
	}
	cout << '\n';
}

int check_shape(pair<int, int> p[3]) {
	//x좌표가 모두 같을 경우 ㅡ
	if (p[0].first == p[1].first && p[1].first == p[2].first)
		return 0;
	//아니면 ㅣ
	else
		return 1;
}

bool turn(int x, int y, int s) {
	if (s == 0) {	//ㅡ
		for (int k = 0; k < 8; k++) {
			if (k == 3 || k == 4) continue;

			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
			if (arr[nx][ny] == '1') return false;
		}
	}
	else {	//ㅣ
		for (int k = 0; k < 8; k++) {
			if (k == 1 || k == 6) continue;

			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
			if (arr[nx][ny] == '1') return false;
		}
	}
	return true;
}

int bfs(int x, int y) {
	queue<pair<pair<int, int>, pair<int, int>>> q;
	q.push({{ x, y }, { B_shape, 0 }});
	vis[x][y][B_shape] = true;

	while (!q.empty()) {
		x = q.front().first.first;
		y = q.front().first.second;
		int s = q.front().second.first;
		int cnt = q.front().second.second;
		q.pop();

		//cout << "x=" << x << ", y=" << y << ", s=" << s << ", cnt=" << cnt << '\n';

		if (x == E_center.first && y == E_center.second && s == E_shape) return cnt;

		int nx, ny, nnx, nny;
		if (s == 0) {	//ㅡ
			//cout << "가로 모양===========================\n";
			//up
			nx = x - 1;
			ny = y;
			if (nx >= 0) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][ny] == '0' && arr[nx][ny - 1] == '0' && arr[nx][ny + 1] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//down
			nx = x + 1;
			ny = y;
			if (nx < n) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][ny] == '0' && arr[nx][ny - 1] == '0' && arr[nx][ny + 1] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//left
			nx = x;
			ny = y - 1;
			nny = y - 2;
			if (nny >= 0) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][nny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//right
			nx = x;
			ny = y + 1;
			nny = y + 2;
			if (nny < n) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][nny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//turn
			if (turn(x, y, s)) {
				if (!vis[x][y][1]) {
					vis[x][y][1] = true;
					q.push({ {x, y}, {1, cnt + 1} });
				}
			}
		}
		else {		//ㅣ
			//cout << "세로 모양===========================\n";
			//up
			nx = x - 1;
			nnx = x - 2;
			ny = y;
			if (nnx >= 0) {
				if (!vis[nx][ny][s]) {
					if (arr[nnx][ny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//down
			nx = x + 1;
			nnx = x + 2;
			ny = y;
			if (nnx < n) {
				if (!vis[nx][ny][s]) {
					if (arr[nnx][ny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//left
			nx = x;
			ny = y - 1;
			if (ny >= 0) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][ny] == '0' && arr[nx - 1][ny] == '0' && arr[nx + 1][ny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//right
			nx = x;
			ny = y + 1;
			if(ny < n) {
				if (!vis[nx][ny][s]) {
					if (arr[nx][ny] == '0' && arr[nx - 1][ny] == '0' && arr[nx + 1][ny] == '0') {
						vis[nx][ny][s] = true;
						q.push({ {nx, ny}, {s, cnt + 1} });
					}
				}
			}

			//turn
			if (turn(x, y, s)) {
				if (!vis[x][y][0]) {
					vis[x][y][0] = true;
					q.push({ {x, y}, {0, cnt + 1} });
				}
			}
		}

		//print_vis();
	}

	return 0;
}

int main() {
	init();
	cin >> n;
	int B_idx = 0, E_idx = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'B') {
				arr[i][j] = '0';
				BBB[B_idx].first = i;
				BBB[B_idx].second = j;
				B_idx++;
			}
			else if (arr[i][j] == 'E') {
				arr[i][j] = '0';
				EEE[E_idx].first = i;
				EEE[E_idx].second = j;
				E_idx++;
			}
		}
	}

	B_center.first = BBB[1].first;
	B_center.second = BBB[1].second;
	E_center.first = EEE[1].first;
	E_center.second = EEE[1].second;

	//cout << "B_center x=" << B_center.first << ", y=" << B_center.second << '\n';
	//cout << "E_center x=" << E_center.first << ", y=" << E_center.second << '\n';

	B_shape = check_shape(BBB);
	E_shape = check_shape(EEE);

	//cout << "B_shape=" << B_shape << ", E_shape=" << E_shape << '\n';

	int ans = bfs(B_center.first, B_center.second);
	cout << ans;

	return 0;
}
