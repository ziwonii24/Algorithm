#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 101;
int n, x, y, d, g;
int arr[MAX][MAX];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { 1,0,-1,0 };
vector<int> v;


void make_dragoncurve() {
	int vsize = v.size();
	for (int i = vsize - 1; i >= 0; i--) {	//규칙상, 역순으로 해야됨
		int nd = (v[i] + 1) % 4;	//다음 방향 0,1,2,3
		x = x + dx[nd];
		y = y + dy[nd];
		arr[x][y] = 1;
		v.push_back(nd);
	}
}

int cnt_square() {
	int cnt = 0;
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < MAX; j++) {
			if (arr[i][j] == 1 && arr[i + 1][j] == 1 &&
				arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1)
				cnt++;
		}
	}
	return cnt;
}

int main() {
	init();
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> y >> x >> d >> g;
		v.clear();

		//0세대 선분하나 그리기
		arr[x][y] = 1;
		x = x + dx[d];
		y = y + dy[d];
		arr[x][y] = 1;

		v.push_back(d);	//v에 방향 저장

		//드래곤 커브 그리기
		for (int j = 0; j < g; j++)
			make_dragoncurve();
	}
	//정사각형 개수 세기
	cout << cnt_square();
	return 0;
}
