#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 50 + 2;
int n, m, p_idx, ans = 987654321;
int arr[MAX][MAX], vis[MAX][MAX];
pair<int, int> place[10];
vector<int> v;
bool check[10];
queue<pair<int, int>> q;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void init_vis() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			vis[i][j] = -1;
}

void bfs() {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (vis[nx][ny] == -1 && (arr[nx][ny] == 0 || arr[nx][ny] == 2)) {
					vis[nx][ny] = vis[x][y] + 1;
					q.push({ nx, ny });
				}
			}
		}
	}
}

int get_time() {
	int min_time = -1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (vis[i][j] == -1 && arr[i][j] == 0) return -1;
			if (min_time < vis[i][j]) 
				min_time = vis[i][j];
		}
	}
	return min_time;
}

void dfs(int x) {	//place에 들어있는 장소중에 m개의 장소 고르기
	if (v.size() == m) {
		init_vis();

		for (int i = 0; i < v.size(); i++) {
			int xx = place[v[i]].first;
			int yy = place[v[i]].second;
			vis[xx][yy] = 0;
			q.push({ xx, yy });
		}

		bfs();

		int min_time = get_time();
		if (min_time != -1)
			ans = min(ans, min_time);
		
		return;
	}

	for (int i = x; i < p_idx; i++) {
		if (!check[i]) {
			check[i] = true;
			v.push_back(i);
			dfs(i + 1);
			check[i] = false;
			v.pop_back();
		}
	}
}

int main() {
	init();
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 2) {
				place[p_idx].first = i;
				place[p_idx].second = j;
				p_idx++;
			}
		}
	}

	dfs(0);

	if (ans == 987654321) cout << -1;
	else cout << ans;
	
	return 0;
}
