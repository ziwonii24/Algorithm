#include <iostream>
#include <algorithm>
#include <queue>
#include <cmath>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 10000;
bool prime[MAX];	//false가 소수, true면 소수가 아님!
int vis[MAX];
int a, b;

// 1000부터 9999까지 소수인지 아닌지 에라토스테네스의 체로 체크하기
void eratos() {
	for (int i = 2; i < sqrt(MAX); i++) {	//나눌 수
		if (!prime[i]) {
			for (int j = 2; j < MAX; j++) {	//나눠지는 수
				if (i != j && j%i == 0) {
					prime[j] = true;
				}
			}
		}
	}
}

void init_vis() {
	for (int i = 0; i < MAX; i++)
		vis[i] = -1;
}

int bfs() {
	queue<int> q;
	q.push(a);
	vis[a] = 0;

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		if (x == b) return vis[b];

		//천의자리수 바꾸기
		for (int k = 1; k <= 9; k++) {
			int nx = x - x / 1000 * 1000 + k * 1000;

			if (vis[nx] == -1 && !prime[nx]) {	//아직방문안했고, 소수이면
				vis[nx] = vis[x] + 1;
				q.push(nx);
			}
		}

		//백의자리수 바꾸기
		for (int k = 0; k <= 9; k++) {
			int x1 = x / 1000;	//천의자리수 저장 8
			int tmp = x - x / 1000 * 1000;	//179
			int nx = (tmp - tmp / 100 * 100) + (k * 100) + (x1 * 1000);

			if (vis[nx] == -1 && !prime[nx]) {	//아직방문안했고, 소수이면
				vis[nx] = vis[x] + 1;
				q.push(nx);
			}
		}

		//십의자리수 바꾸기
		for (int k = 0; k <= 9; k++) {
			int x1 = x / 1000;	//천의자리수 저장 8
			int tmp = x - x / 1000 * 1000;	//179
			int x2 = tmp / 100;;	//백의자리수 저장 1
			tmp = tmp - tmp / 100 * 100;	//79
			int nx = (tmp - tmp / 10 * 10) + (k * 10) + (x2 * 100) + (x1 * 1000);

			if (vis[nx] == -1 && !prime[nx]) {	//아직방문안했고, 소수이면
				vis[nx] = vis[x] + 1;
				q.push(nx);
			}
		}

		//일의자리수 바꾸기
		for (int k = 0; k <= 9; k++) {
			int tmp = x - x % 10;	//8179 - 9 = 8170
			int nx = tmp + k;

			if (vis[nx] == -1 && !prime[nx]) {	//아직방문안했고, 소수이면
				vis[nx] = vis[x] + 1;
				q.push(nx);
			}
		}
	}

	return -1;
}

int main() {
	init();
	eratos();

	int tc;
	cin >> tc;
	while (tc--) {
		cin >> a >> b;
		init_vis();
		int ans = bfs();
		if (ans == -1) cout << "Impossible\n";
		else cout << ans << '\n';
	}

	return 0;
}
