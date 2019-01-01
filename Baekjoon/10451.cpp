#include <iostream>
#include <vector>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

vector<int> a[1010];
int check[1010];

void dfs(int node) {
	check[node] = 1;
	for (int i = 0; i < a[node].size(); i++) {
		int next = a[node][i];
		if (check[next] == 0)
			dfs(next);
	}
}

int main() {
	int tc;
	cin >> tc;
	while (tc--) {
		int n;
		cin >> n;

		for (int i = 0; i <= n; i++) {
			a[i].clear();
			check[i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			int u;
			cin >> u;
			a[i].push_back(u);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				dfs(i);
				cnt++;
			}
		}

		cout << cnt << '\n';
	}

	return 0;
}
