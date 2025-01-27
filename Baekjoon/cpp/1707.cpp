#include <iostream>
#include <vector>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

vector<int> a[200020];
int check[200020];

void dfs(int x, int c) {
	check[x] = c;
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i];
		if (check[y] == 0)
			dfs(y, 3-c);
	}
}

int main() {
	int tc;
	cin >> tc;
	while (tc--) {
		int n, m;
		cin >> n >> m;

		for (int i = 0; i <= n; i++) {
			a[i].clear();
			check[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int u, v;
			cin >> u >> v;
			a[u].push_back(v);
			a[v].push_back(u);
		}

		for (int i = 1; i <= n; i++) {
			if (check[i] == 0)
				dfs(i, 1);
		}

		bool ok = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < a[i].size(); j++) {
				int k = a[i][j];
				if (check[i] == check[k])
					ok = false;
			}
		}

		printf("%s\n", ok ? "YES" : "NO");
	}

	return 0;
}
