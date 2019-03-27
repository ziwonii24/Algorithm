#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 51;
int n, m, gx, gy;
char smap[MAX][MAX];
int go[MAX][MAX], water[MAX][MAX];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue<pair<int, int>> wq, sq;

void water_bfs() {	//물을 이동시키는 bfs
	while (!wq.empty()) {
		int x = wq.front().first;
		int y = wq.front().second;
		wq.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (water[nx][ny] == -1 && (smap[nx][ny] == '.' || smap[nx][ny] == 'S')) {
					water[nx][ny] = water[x][y] + 1;
					wq.push({ nx, ny });
				}
			}
		}
	}
}

void go_bfs() {	//고슴도치를 이동시키는 bfs
	while (!sq.empty()) {
		int x = sq.front().first;
		int y = sq.front().second;
		sq.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (go[nx][ny] == -1 ) {	//아직 방문하지 않은 곳이고,
					if (smap[nx][ny] == 'D'	//그 곳이 비버의 굴이거나,
						|| (smap[nx][ny] == '.'		//빈칸이면서 물보다 먼저 간 곳이면,
							&& (go[x][y] + 1 < water[nx][ny] || water[nx][ny] == -1))) {
						go[nx][ny] = go[x][y] + 1;
						sq.push({ nx, ny });
					}
				}
			}
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			go[i][j] = -1;
			water[i][j] = -1;
		}
	}
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			smap[i][j] = str[j];
			if (smap[i][j] == '*') {
				wq.push({ i, j });
				water[i][j] = 0;
			}
			else if (smap[i][j] == 'S') {
				sq.push({ i, j });
				go[i][j] = 0;
			}
			else if (smap[i][j] == 'D') {	//목적지 좌표 저장
				gx = i;
				gy = j;
			}
		}
	}

	water_bfs();
	go_bfs();
	
	if (go[gx][gy] == -1) cout << "KAKTUS";
	else cout << go[gx][gy];

	return 0;
}
