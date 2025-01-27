#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 100;
int n, m, arr[MAX + 1][MAX + 1], vis[MAX + 1][MAX + 1];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void init_vis() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			vis[i][j] = 0;
}

void melting() {	//2로 표시되어있는 부분 녹이기
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (vis[i][j] == 2)
				arr[i][j] = 0;
}

int piece_cnt_bfs(int x, int y) {	//치즈가 있는 칸 세기
	int cnt = 0;
	queue<pair<int, int>> q;
	q.push({ x, y });
	vis[x][y] = 1;
	cnt++;

	while (!q.empty()) {
		x = q.front().first;	
		y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (vis[nx][ny] == 0 && arr[nx][ny] == 1) {
					cnt++;
					vis[nx][ny] = 1;
					q.push({ nx, ny });
				}
			}
		}
	}

	return cnt;
}

void melt_bfs() {	//치즈 녹일 부분 표시하기 vis배열을 2로
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	vis[0][0] = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		 
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (vis[nx][ny] == 0){
					if (arr[nx][ny] == 0) {
						vis[nx][ny] = 1;
						q.push({ nx, ny });
					}
					else if (arr[nx][ny] == 1) {
						vis[nx][ny] = 2;
					}
				}
				
			}
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];

	int cheeze_cnt = 0, ans_cheeze = 0, ans_time = 0;
	while (1) {
		init_vis();

		ans_cheeze = cheeze_cnt;
		cheeze_cnt = 0;
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (vis[i][j] == 0 && arr[i][j] == 1)
					cheeze_cnt += piece_cnt_bfs(i, j);	//치즈가 있는 칸 세기

		if (cheeze_cnt == 0) break;	//치즈가 모두 녹았으면 끝
		init_vis();

		ans_time++;
		melt_bfs();
		melting();
	}
	cout << ans_time << '\n' << ans_cheeze;
	return 0;
}
