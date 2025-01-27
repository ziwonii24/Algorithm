#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int n;
int a[100001];
int check[100001];
int s[100001];

int dfs(int x, int cnt, int &step) {
	if (check[x] != 0) {
		if (step != s[x])
			return 0;
		return cnt - check[x];
	}

	check[x] = cnt;
	s[x] = step;

	return dfs(a[x], cnt + 1, step);
}

int main() {
	int tc;
	cin >> tc;
	while (tc--) {
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			check[i] = 0;
			s[i] = 0;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0)
				ans += dfs(i, 1, i);
		}

		cout << n-ans << '\n';
	}

	return 0;
}
