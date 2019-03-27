#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 101;
int n, arr[MAX][MAX];
bool vis[MAX];

void init_vis() {
	for (int i = 1; i <= n; i++)
		vis[i] = false;
}

void dfs(int x) {
	for (int i = 1; i <= n; i++) {
		if (arr[x][i] == 1 && !vis[i]) {
			vis[i] = true;
			dfs(i);
		}
	}
}

void print_ans() {
	for (int i = 1; i <= n; i++) {
		if (vis[i]) cout << 1 << ' ';
		else cout << 0 << ' ';
	}
	cout << '\n';
}

int main() {
	init();
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			cin >> arr[i][j];

	for (int i = 1; i <= n; i++) {
		init_vis();
		dfs(i);
		print_ans();
	}

	return 0;
}
