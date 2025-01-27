#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 50;
int n, L, R;
int arr[MAX + 1][MAX + 1], group[MAX + 1][MAX + 1];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int gcnt;

void init_vis() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			group[i][j] = 0;
}

int bfs(int x, int y, int gnum) {
	queue<pair<int, int>> q;
	q.push({ x, y });
	group[x][y] = gnum;
	
	gcnt = 1;
	int gsum = arr[x][y];

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				int diff = abs(arr[x][y] - arr[nx][ny]);
				if (group[nx][ny] == 0 && L <= diff && diff <= R) {
					group[nx][ny] = gnum;
					q.push({ nx, ny });
					
					gcnt++;
					gsum += arr[nx][ny];
				}
			}
		}
	}

	return gsum / gcnt;
}

int main() {
	init();
	cin >> n >> L >> R;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

	int ans = 0;
	while (1) {
		init_vis();

		vector<pair<int, int>> v;	//gnum, np;
		int gnum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (group[i][j] == 0) {
					int np = bfs(i, j, ++gnum);	//그 그룹의 새로운 인구수
					if(gcnt != 1)	//그룹 칸의 개수가 2이상인것만 갱신하도록
						v.push_back({ gnum, np });
				}
			}
		}

		if (gnum == n * n) break;	//더이상 인구이동 못하는경우
		ans++;	//인구이동 횟수 증가

		for (int k = 0; k < v.size(); k++) {
			int a = v[k].first;		//group number;
			int b = v[k].second;	//new people

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (group[i][j] == a) {
						arr[i][j] = b;
					}
				}
			}
		}
	}
	cout << ans;

	return 0;
} 
