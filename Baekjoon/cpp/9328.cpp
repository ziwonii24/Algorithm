#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 110;
int n, m;
char arr[MAX][MAX];
bool vis[MAX][MAX], key[26];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
string skey;
int ans;

void init_val() {
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < MAX; j++) {
			arr[i][j] = 0;
			vis[i][j] = false;
		}
	}
	for (int i = 0; i < 26; i++)
		key[i] = false;

	skey = "";
	ans = 0;
}

void bfs() {
	queue<pair<int, int>> q;		//bfs를 위한 queue
	queue<pair<int, int>> door[26];	//문의 좌표를 저장하기 위한 queue
	q.push({ 0,0 });
	vis[0][0] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n + 2 && ny >= 0 && ny < m + 2) {
				if (vis[nx][ny] || arr[nx][ny] == '*') continue;
				vis[nx][ny] = true;

				if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'Z') {	//문
					if (key[arr[nx][ny] - 'A'])	//열쇠가 있는 경우
						q.push({ nx, ny });
					else
						door[arr[nx][ny] - 'A'].push({ nx, ny });
				}
				else if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'z') {	//열쇠
					q.push({ nx, ny });
					if (!key[arr[nx][ny] - 'a']) {	//처음갖는열쇠면
						key[arr[nx][ny] - 'a'] = true;

						while (!door[arr[nx][ny] - 'a'].empty()) {
							q.push(door[arr[nx][ny] - 'a'].front());
							door[arr[nx][ny] - 'a'].pop();
						}
					}
				}
				else {	//빈칸 또는 문서
					q.push({ nx, ny });
					if (arr[nx][ny] == '$') ans++;
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
		init_val();
		cin >> n >> m;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				cin >> arr[i][j];
		cin >> skey;

		if (skey != "0") {
			for (int i = 0; i < skey.length(); i++)
				key[skey[i] - 'a'] = true;
		}

		bfs();
		cout << ans << '\n';
	}

	return 0;
}
