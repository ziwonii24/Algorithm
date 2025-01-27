#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 100000 + 1;
int n, k, ans, cnt;
bool vis[MAX];

void bfs() {
	queue<pair<int, int>> q;
	q.push({ n, 0 });
	vis[n] = true;

	while (!q.empty()) {
		int x = q.front().first;	//현재위치
		int sec = q.front().second;	//걸린시간
		q.pop();
		vis[x] = true;	//pop할때 방문했다는 표시

		if (ans != 0 && ans < sec)	return;

		if (ans == sec && x == k) //이미 목적지에 한번 방문했으면, 횟수증가!
			cnt++;

		if (ans == 0 && x == k) { //목적지에 처음 방문한 경우, 기록 후 횟수증가!
			ans = sec;
			cnt++;
		}

		if (x - 1 >= 0 && !vis[x - 1]) q.push({ x - 1,sec + 1 });
		if (x + 1 < MAX && !vis[x + 1]) q.push({ x + 1,sec + 1 });
		if (2 * x < MAX && !vis[2 * x]) q.push({ 2 * x,sec + 1 });
	}
}

int main() {
	init();
	cin >> n >> k;
	if (n == k) {
		cout << 0 << '\n' << 1;
		return 0;
	}
	bfs();
	cout << ans << '\n' << cnt;
	return 0;
}
