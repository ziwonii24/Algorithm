#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

string start, goal = "123456780";
set<string> vis;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int bfs() {
	queue<pair<string, int>> q;	//현재 문자열과 걸린 시간
	q.push({ start, 0 });
	vis.insert(start);

	while (!q.empty()) {
		string str = q.front().first;
		int time = q.front().second;
		q.pop();

		if (str == goal) return time;

		int zero = str.find('0');	//0의 인덱스
		int x = zero / 3;
		int y = zero % 3;	//3x3배열에서의 0의 좌표(x, y)

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
				string nstr = str;
				swap(nstr[x * 3 + y], nstr[nx * 3 + ny]);	//0이랑 자리바꾸기

				if (vis.find(nstr) == vis.end()) {	//문자열에 방문한 적 없으면
					vis.insert(nstr);
					q.push({ nstr, time + 1 });
				}
			}
		}
	}

	return -1;
}

int main() {
	init();
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			int a;
			cin >> a;
			start += a + '0';
		}
	}

	cout << bfs();

	return 0;
}
