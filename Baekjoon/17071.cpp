#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 500000 + 1;
int n, k;
int subin[2][MAX];

void bfs() {	//수빈의 방문지점을 짝수시간/홀수시간 나눠서 저장
	queue<pair<int, int>> q;
	q.push({ n, 0 });
	subin[0][n] = 0;

	while (!q.empty()) {
		int x = q.front().first;
		int sec = q.front().second;
		q.pop();

		if (x - 1 >= 0) {
			if (subin[(sec + 1) % 2][x - 1] == -1) {
				subin[(sec + 1) % 2][x - 1] = sec + 1;
				q.push({ x - 1, sec + 1 });
			}
		}
		if (x + 1 < MAX) {
			if (subin[(sec + 1) % 2][x + 1] == -1) {
				subin[(sec + 1) % 2][x + 1] = sec + 1;
				q.push({ x + 1, sec + 1 });
			}
		}
		if (x * 2 < MAX) {
			if (subin[(sec + 1) % 2][x * 2] == -1) {
				subin[(sec + 1) % 2][x * 2] = sec + 1;
				q.push({ x * 2, sec + 1 });
			}
		}
	}
}

int main() {
	init();
	cin >> n >> k;
	for (int i = 0; i < MAX; i++) {
		subin[0][i] = -1;
		subin[1][i] = -1;
	}

	bfs();

	int sis = k, sis_sec = 0, ans = MAX;
	while (sis < MAX) {
		// -1 < subin[sis_sec % 2][sis] <= sis_sec
		if (subin[sis_sec % 2][sis] > -1 && subin[sis_sec % 2][sis] <= sis_sec)
			ans = min(ans, sis_sec);
		sis_sec++;
		sis += sis_sec;
	}

	if (ans == MAX) cout << -1;
	else cout << ans;	

	return 0;
}
