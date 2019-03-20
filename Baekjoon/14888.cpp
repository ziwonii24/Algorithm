#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

const int mx = 12;
int n;
int num[mx], oper[mx], check[mx];
vector<int> v;
int result, ans_min = 1000000001, ans_max = -1000000001;

void dfs(int x) {
	if (v.size() == n - 1) {
		result = num[0];
		for (int i = 0; i < v.size(); i++) {
			if (v[i] == 1) result += num[i + 1];
			else if (v[i] == 2) result -= num[i + 1];
			else if (v[i] == 3) result *= num[i + 1];
			else result /= num[i + 1];
		}
		ans_min = min(ans_min, result);
		ans_max = max(ans_max, result);
		return;
	}

	for (int i = 0; i < n - 1; i++) {
		if (!check[i]) {
			check[i] = 1;
			v.push_back(oper[i]);
			dfs(i + 1);
			v.pop_back();
			check[i] = 0;
		}
	}
}

int main() {
	init();
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> num[i];
	int idx = 0;
	for (int i = 1; i <= 4; i++) {
		int op;
		cin >> op;
		for (int j = idx; j < idx + op; j++)
			oper[j] = i;
		idx += op;
	}

	dfs(0);
	cout << ans_max << '\n' << ans_min;

	return 0;
}
