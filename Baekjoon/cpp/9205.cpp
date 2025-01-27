#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
}

const int MAX = 100 + 2;
int n;
vector<int> v[MAX];
bool vis[MAX];

int ManhattanDist(pair<int, int> p1, pair<int, int> p2) {
	return abs(p1.first - p2.first) + abs(p1.second - p2.second);
}

void dfs(int x) {
	vis[x] = true;

	for (int i = 0; i < v[x].size(); i++) {
		int y = v[x][i];
		if (!vis[y]) dfs(y);
	}
}

void init_arr() {
	for (int i = 0; i < MAX; i++) {
		v[i].clear();
		vis[i] = false;
	}
}

int main() {
	init();

	int tc;
	cin >> tc;
	while (tc--) {
		init_arr();

		vector<pair<int, int>> vp;
		cin >> n;
		for (int i = 0; i < n + 2; i++) {
			int x, y;
			cin >> x >> y;
			vp.push_back({ x, y });
		}

		for (int i = 0; i < n + 2; i++) {
			for (int j = i + 1; j < n + 2; j++) {
				if (ManhattanDist(vp[i], vp[j]) <= 20 * 50) {
					v[i].push_back(j);
					v[j].push_back(i);
				}
			}
		}

		dfs(0);

		if (vis[n + 1]) cout << "happy\n";
		else cout << "sad\n";
	}

	return 0;
}
