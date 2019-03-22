#include <iostream>
#include <algorithm>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 21;
int n, m;
int a[MAX], b[MAX];

int sol() {
	int ans = -987654321;
	if (n < m) {
		for (int k = 0; k < m - n + 1; k++) {
			int sum = 0;
			for (int i = 0; i < n; i++)
				sum += a[i] * b[i + k];
			ans = max(ans, sum);
		}
	}
	else {
		for (int k = 0; k < n - m + 1; k++) {
			int sum = 0;
			for (int i = 0; i < m; i++)
				sum += a[i + k] * b[i];
			ans = max(ans, sum);
		}
	}
	return ans;
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> n >> m;
		for (int i = 0; i < n; i++)
			cin >> a[i];
		for (int i = 0; i < m; i++)
			cin >> b[i];

		cout << '#' << T << ' ' << sol() << '\n';
	}
	return 0;
}
