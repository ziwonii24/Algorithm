#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 15;
int n, m, d;
int arr[MAX + 2][MAX + 2], vis[MAX + 2][MAX + 2], tmp[MAX + 2][MAX + 2];
bool check[MAX + 2], army[MAX + 2][MAX + 2];
vector<int> v;
int dx[3] = { -1,0,0 };
int dy[3] = { 0,1,-1 };
int ans, cnt;

void copy_arr() {	//tmp에 arr복사(궁수배치마다 적 얼마나 죽일지 모르니깐)
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			tmp[i][j] = arr[i][j];
}

int remain_army() {	//적이 남아있는지 확인
	int cnt_army = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (tmp[i][j] == 1)
				cnt_army++;
	return cnt_army;
}

void init_vis() {	//vis배열 초기화
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			vis[i][j] = 0;
}

void print_vis() {
	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << vis[i][j] << ' ';
		cout << '\n';
	}
	cout << '\n';
}

void print_army() {
	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << army[i][j] << ' ';
		cout << '\n';
	}
	cout << '\n';
}

void bfs(int y) {		//사정거리내 죽일 적 표시하기 위함
	cout << "*궁수 열번호 = " << y << '\n';

	queue<pair<int, int>> q;
	q.push({ n - 1, y });
	vis[n - 1][y] = 1;

	cout << "*\n";
	print_vis();

	int xx = MAX + 2, yy = MAX + 2, dd = MAX + 2;	//현재 궁수가 쏘게 될 적의 위치

	if (tmp[n - 1][y] == 1) {	
		xx = n - 1; 
		yy = y;
		dd = vis[n - 1][y];
	}

	cout << "*xx=" << xx << ", yy=" << yy << ", dd=" << dd << '\n';

	while (!q.empty()) {
		int x = q.front().first;
		y = q.front().second;
		q.pop();

		cout << "x=" << x << ", y=" << y << '\n';
		print_vis();

		if (vis[x][y] == d) {	//공격할 수 있는 거리까지 모두 본상태
			cout << "xx=" << xx << ", yy=" << yy << ", dd=" << dd << '\n';
			if (xx != MAX + 2 && yy != MAX + 2) {	//쏠 적이 있으면 표시
				army[xx][yy] = true;

				print_army();
			}
			return;
		}

		for (int k = 0; k < 3; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			cout << "nx=" << nx << ", ny=" << ny << '\n';

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (vis[nx][ny] == 0) {	//공격할 수 있는 범위까지 넓혀가기 위함
					vis[nx][ny] = vis[x][y] + 1;	
					q.push({ nx, ny });

					print_vis();

					if (tmp[nx][ny] == 1) {	
						if (vis[nx][ny] <= dd && ny < yy) {//가장 가깝고 왼쪽에 있는 적인지 확인
							xx = nx;
							yy = ny;
							dd = vis[nx][ny];
							cout << "xx=" << xx << ", yy=" << yy << ", dd=" << dd << '\n';
						}
					}
				}
			}
		}
	}
}

void print_tmp() {
	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << tmp[i][j] << ' ';
		cout << '\n';
	}
	cout << '\n';
}

void update_tmp() {
	cout << "표시된 적\n";
	print_army();

	//표시된 적 없애기
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (army[i][j]) {
				tmp[i][j] = 0;
				cnt++;
			}
		}
	}

	cout << "cnt=" << cnt << '\n';

	cout << "적군 전진 전 \n";
	print_tmp();

	//적군 한칸 전진
	for (int i = n - 1; i >= 0; i--) {
		for (int j = m - 1; j >= 0; j--) {
			if (tmp[i][j] == 1) {
				tmp[i + 1][j] = tmp[i][j];
				tmp[i][j] = 0;
			}
		}
	}

	
}

void init_army() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			army[i][j] = false;
}

void dfs(int x) {	//궁수 배치(열 번호만)
	if (v.size() == 3) {
		init_army();
		init_vis();
		copy_arr();

		while (1) {
			cout << "*적군의 현황\n";
			print_tmp();

			cout << "*남은 적군의 수 = " << remain_army() << '\n';
			if (remain_army() == 0) {
				ans = max(ans, cnt);
				cnt = 0;
				break;
			}

			for (int i = 0; i < v.size(); i++) {
				init_vis();
				bfs(v[i]);	//궁수 한명에 대해 쏠 적 찾기
			}

			update_tmp();
			init_army();
		}		

		return;
	}

	for (int i = x; i < m; i++) {
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
	cin >> n >> m >> d;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];

	dfs(0);
	cout << ans;

	return 0;
}
