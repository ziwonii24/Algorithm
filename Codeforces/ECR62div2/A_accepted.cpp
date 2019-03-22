#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 10005;
int n;
int a[MAX];
bool check[MAX];

int main() {
	init();
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];

	int cnt = 0, k = 0;
	bool flag = false;
	for (int i = 1; i <= n; i++) {
		flag = false;
		k = a[i];

		for (int j = i; j <= k; j++) {
			if (!check[j]) {
				check[j] = true;
				if (k < a[j]) k = a[j];
				flag = true;
			}
		}

		if (flag) cnt++;
	}
	cout << cnt;

	return 0;
}