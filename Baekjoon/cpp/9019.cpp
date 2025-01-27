#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 10000;
int a, b;
bool vis[MAX + 1];
string ans;

void init_vis() {
	for (int i = 0; i < MAX; i++)
		vis[i] = false;
}

void bfs() {
	queue<pair<int, string>> q;
	q.push({ a, "" });
	vis[a] = true;

	while (!q.empty()) {
		int n = q.front().first;
		string cmd = q.front().second;
		q.pop();

		if (n == b) {
			ans = cmd;
			return;
		}

		//D
		int D = 2 * n;
		if (D >= MAX) D %= MAX;
		if (!vis[D]) {
			vis[D] = true;
			q.push({ D, cmd + 'D' });
		}

		//S
		int S = n - 1;
		if (n == 0) S = 9999;
		if (!vis[S]) {
			vis[S] = true;
			q.push({ S, cmd + 'S' });
		}

		//L, R
		if (n < 10) {	//자리수 한개
			int L = n * 10;
			if (!vis[L]) {
				vis[L] = true;
				q.push({ L, cmd + 'L' });
			}

			//R
			int R = n * 1000;
			if (!vis[R]) {
				vis[R] = true;
				q.push({ R, cmd + 'R' });
			}
		}
		else if (n >= 10 && n < 100) {	//자리수 두개
			int L = n * 10;
			if (!vis[L]) {
				vis[L] = true;
				q.push({ L, cmd + 'L' });
			}

			//R
			int R = n % 10 * 1000 + n / 10;
			if (!vis[R]) {
				vis[R] = true;
				q.push({ R, cmd + 'R' });
			}
		}
		else if (n >= 100 && n < 1000) {	//자리수 세개
			//L
			int L = n * 10;
			if (!vis[L]) {
				vis[L] = true;
				q.push({ L, cmd + 'L' });
			}

			//R
			int R = n % 10 * 1000 + n / 10;
			if (!vis[R]) {
				vis[R] = true;
				q.push({ R, cmd + 'R' });
			}
		}
		else if (n >= 1000) {	//자리수 네개
			//L
			int L = n % 1000 * 10 + n / 1000;
			if (!vis[L]) {
				vis[L] = true;
				q.push({ L, cmd + 'L' });
			}

			//R
			int R = n / 10 + n % 10 * 1000;
			if (!vis[R]) {
				vis[R] = true;
				q.push({ R, cmd + 'R' });
			}
		}
	}
}

int main() {
	init();
	int tc;
	cin >> tc;
	while (tc--) {
		cin >> a >> b;
		init_vis();
		bfs();
		cout << ans << '\n';
	}
	return 0;
}
