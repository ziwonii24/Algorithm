#include <iostream>
#include <vector>
using namespace std;

vector<int> a[1010];
int check[1010];

void dfs(int x) {
	check[x] = 1;
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i];
		if (check[y] == 0)
			dfs(y);
	}
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}

	int cnt = 0; 
	for (int i = 1; i <= n; i++) {
		if (check[i] == 0) {
			cnt++;
			dfs(i);
		}
	}

	cout << cnt << '\n';

	return 0;
}
