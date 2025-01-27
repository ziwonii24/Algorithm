#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

const int mx = 51;
int dx[4] = { -1,0,1,0 };	//위,왼,아,오
int dy[4] = { 0,-1,0,1 };
int n, m, r, c, d;
int arr[mx][mx];
int ans = 0;

void cleaning(int x, int y, int dir) {
	if (!arr[x][y]) {	//청소
		ans++;
		arr[x][y] = 2;	//청소했다는 표시
	}   

	for (int k = dir + 1; k < dir + 5; k++) {
		int nx = x + dx[k % 4];
		int ny = y + dy[k % 4];
		if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
			if (!arr[nx][ny])
				cleaning(nx, ny, k % 4);
		}
	}

	//네 방향 탐색해도 갈데가 없으면 for문을 나와서 후진과정을 거침
	int bx = x + dx[(dir + 2) % 4];	//로봇의 등뒤
	int by = y + dy[(dir + 2) % 4];
	if (arr[bx][by] == 2)	//방향 그대로 유지하면서 후진
		cleaning(bx, by, dir);
	else if (arr[bx][by] == 1) {	//후진도 할 수 없는 경우
		cout << ans;
		exit(0);	//집안을 다 청소하지 못할 수도 있음
	}
}

int main() {
	init();
	cin >> n >> m >> r >> c >> d;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];

	//이걸 왜하는 건지 모르겠음
	if (d == 3) d = 1;
	else if (d == 1) d = 3;

	cleaning(r, c, d);
	cout << ans;
	return 0;
}
