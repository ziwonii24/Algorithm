#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 300003;
int n, k;
int len[MAX], beauty[MAX];
vector<int> v;
int ans = 0;
bool check[MAX];
int mmb = 987654321;

bool pruning(int idx) {
	if (beauty[idx] == mmb)
		return true;
	return false;
}

void dfs(int x, int k) {
	if (v.size() == k) {
		int total_len = 0;
		for (int i = 0; i < v.size(); i++)
			/*cout << v[i] << ' ';
		cout << '\n';*/
			total_len += len[v[i]];

		int min_beauty = 987654321;
		for (int i = 0; i < v.size(); i++)
			min_beauty = min(min_beauty, beauty[v[i]]);

		ans = max(ans, total_len*min_beauty);
		return;
	}

	for (int i = x; i < n; i++) {
		if (pruning(i)) continue;
		if (!check[i]) {
			check[i] = true;
			v.push_back(i);
			dfs(i+1, k);
			v.pop_back();
			check[i] = false;
		}
	}
}

int main() {
	init();
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> len[i] >> beauty[i];
		mmb = min(mmb, beauty[i]);
	}

	for (int i = 1; i <= k; i++)
		dfs(0, i);
	cout << ans;
	return 0;
}
