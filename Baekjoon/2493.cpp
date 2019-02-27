#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int n;
int arr[500005], ans[500005];
stack<pair<int, int>> stk;

int main() {
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];

	for (int i = 1; i <= n; i++) {
		if (stk.empty())
			stk.push({ i, arr[i] });
		else {
			while (stk.top().second < arr[i]) {
				stk.pop();
				if (stk.empty()) break;
			}
			if (!stk.empty())
				ans[i] = stk.top().first;
			stk.push({ i, arr[i] });
		}
	}

	for (int i = 1; i <= n; i++)
		cout << ans[i] << ' ';
	cout << '\n';

	return 0;
}
