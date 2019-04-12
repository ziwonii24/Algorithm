#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

struct ARMY {
	int xx, yy, dd;
};

const int MAX = 15 + 2;
int n, m, D;
int arr[MAX][MAX], vis[MAX][MAX], tmp[MAX][MAX];
int dx[3] = { 0,0,-1 };
int dy[3] = { 1,-1,0 };	//왼쪽, 오른쪽, 위쪽
bool check[MAX];
vector<int> v;
vector<ARMY> army;
vector<ARMY> army_kill;
int kill_cnt, ans;

void print_vis() {
	cout << "vis======================\n";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << vis[i][j] << ' ';
		cout << '\n';
	}
	cout << '\n';
}

void print_tmp() {
	cout << "tmp======================\n";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << tmp[i][j] << ' ';
		cout << '\n';
	}
	cout << '\n';
}

void print_army() {
	cout << "army=====================\n";
	if (army.empty()) cout << "amry is empty\n";
	else {
		for (int i = 0; i < army.size(); i++)
			cout << army[i].xx << ", " << army[i].yy << ", " << army[i].dd << '\n';
		cout << '\n';
	}
}

void print_armykill() {
	cout << "armykill=================\n";
	if (army_kill.empty()) cout << "amry_kill is empty\n";
	else {
		for (int i = 0; i < army_kill.size(); i++)
			cout << army_kill[i].xx << ", " << army_kill[i].yy << ", " << army_kill[i].dd << '\n';
		cout << '\n';
	}
}

bool comp(const ARMY a, const ARMY b) {
	return (a.dd < b.dd) || (a.dd == b.dd && a.yy < b.yy);
}

void copy_arr() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			tmp[i][j] = arr[i][j];
}

void init_vis() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			vis[i][j] = 0;
}

void bfs(int y) {	//사정거리내에 있는 적의 위치를 찾아내기
	queue<pair<int, int>> q;
	q.push({ n - 1, y });
	vis[n - 1][y] = 1;	//궁수 바로 위부터 방문
	ARMY a;

	if (tmp[n - 1][y] == 1) {
		a.xx = n - 1;
		a.yy = y;
		a.dd = 1;
		army.push_back(a);
	}

	while (!q.empty()) {
		int x = q.front().first;
		y = q.front().second;
		q.pop();

		//사정거리 다 돌았으면 끝
		if (vis[x][y] == D) return;

		for (int k = 0; k < 3; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (vis[nx][ny] == 0) {
					vis[nx][ny] = vis[x][y] + 1;
					q.push({ nx, ny });
				}

				if (tmp[nx][ny] == 1) {
					a.xx = nx;
					a.yy = ny;
					a.dd = vis[nx][ny];
					army.push_back(a);
				}
			}
		}
	}
}

void update_tmp() {
	//적 죽이기
	for (int i = 0; i < army_kill.size(); i++) {	//최소 0개 ~ 최대 3개
		int x = army_kill[i].xx;
		int y = army_kill[i].yy;

		if (tmp[x][y] == 1) {
			tmp[x][y] = 0;
			kill_cnt++;
		}
	}

	/*cout << "죽이고 난 후\n";
	print_tmp();*/

	//적 한 칸 전진
	for (int i = n - 1; i >= 0; i--) {
		for (int j = m - 1; j >= 0; j--) {
			if (tmp[i][j] == 1) {
				tmp[i + 1][j] = tmp[i][j];
				tmp[i][j] = 0;
			}
		}
	}

	/*cout << "전진 한 후\n";
	print_tmp();*/
}

int remain_army() {	//적이 몇명남았는지 세는 함수
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (tmp[i][j] == 1)
				cnt++;
		}
	}
	return cnt;
}

void dfs(int x) {
	if (v.size() == 3) {	//궁수 세명 선택
		/*cout << "궁수 새로 배치\n";
		for (int i = 0; i < v.size(); i++)
			cout << v[i] << ' ';
		cout << '\n';*/

		copy_arr();	//판새로짜기

		while (1) {
			if (remain_army() == 0) {	//남아있는 적이 없으면
				//cout << "이 궁수배치로 죽인 적의 수 = " << kill_cnt << '\n';
				ans = max(ans, kill_cnt);
				kill_cnt = 0;
				break;
			}

			for (int i = 0; i < v.size(); i++) {
				init_vis();	//궁수 한명에 대한 vis배열이라서 초기화
				army.clear();	//궁수 한명에 대한 죽일 적 후보라서 초기화
				bfs(v[i]);

				/*print_vis();
				print_army();*/

				if (!army.empty()) {
					sort(army.begin(), army.end(), comp);
					army_kill.push_back(army.front());//제일가깝고왼쪽에 있는 적만
				}

				//print_armykill();
			}

			//bfs다 돌고 죽일 적 다 고르고 난 후
			update_tmp();	//적 죽이고 적 한칸 전진
			army_kill.clear();
		}

		return;
	}

	//궁수 세명 고르기
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
	cin >> n >> m >> D;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];

	dfs(0);
	cout << ans;

	return 0;
}
